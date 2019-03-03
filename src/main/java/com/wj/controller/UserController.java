package com.wj.controller;

import com.wj.pojo.*;
import com.wj.service.*;
import com.wj.utils.AddCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
@SessionAttributes(value = { "username", "userid","password","email" })
@RequestMapping("/userController")
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentController commentController;
    @Autowired
    CommentService commentService;
    @Autowired
    AttentionService attentionService;
    @Autowired
    CollectService collectService;
    @Autowired
    ViaService viaService;

    @ResponseBody
    @RequestMapping("/getLoginAjax")
    public String login(User user, Map<Object,Object> map, HttpServletRequest request, HttpServletResponse response){
        String username=request.getParameter("name");
        String userpassword=request.getParameter("password");
        user.setName(username);
        user.setPassword(userpassword);
        String rememberFlag=request.getParameter("rememberyesorno");
        System.out.println("接受到的值为"+rememberFlag);
        //判断是否保存登录信息
        //Cookie loginCookie= null;
        if("1".equals(rememberFlag)){
//            Cookie[] cookies=request.getCookies();
//            for(int i=0;i<cookies.length;i++){
//                Cookie cookie=cookies[i];
//                if ("loginInfo".equals(cookie.getName())){
//                    System.out.println("cook");
//                }
//            }
            String loginInfo=(username+","+userpassword);
            System.out.println(loginInfo);
            System.out.println(loginInfo);

//            try {
//                loginCookie = new Cookie("loginInfo", URLEncoder.encode(loginInfo,"UTF-8"));
//            } catch (UnsupportedEncodingException e) {
//                System.out.println("中文转码异常");
//            }
//            loginCookie.setPath("/");
//            loginCookie.setMaxAge(60*60*24);
            AddCookie addCookie=new AddCookie();
            addCookie.addCookie(loginInfo,response);
            System.out.println("结束");
        }
        System.out.println("出来了");
        User user1=userService.getUser(user);
        System.out.println("登录用户的名字为"+user1.getName());
        if(user1.getName()!=null){
            System.out.println("内部");
            int userid=user1.getUserid();
            String name=user1.getName();
            String password=user1.getPassword();
            String email=user1.getEmail();
            map.put("userid",userid);
            map.put("username",name);
            map.put("email",email);
            map.put("password",password);
            //response.addCookie(loginCookie);
            return "OK";

        }else {
            return "NO";
        }
    }
    @RequestMapping("/setSignUp")
    @ResponseBody
    public String  signUp(HttpServletRequest request,Map<Object,Object> map,User user){
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("pass"));
        user.setTime(new Date());
        System.out.println("进来了");
        User user2=userService.getUserName(user);
        System.out.println(user2);
        System.out.println("出来了");
        //System.out.println("名字为"+user2.getName());
        //System.out.println(user2.getName()=="");
        if(user2==null){
            System.out.println("内部");
            System.out.println(user.getName().equals(request.getParameter("repass")));
            if(user.getPassword().equals(request.getParameter("repass"))){

                userService.setUser(user);
                User user1=userService.getUser(user);
                int userid=user1.getUserid();
                String name=user1.getName();
                String password=user1.getPassword();
                String email=user1.getEmail();
                map.put("userid",userid);
                map.put("username",name);
                map.put("email",email);
                map.put("password",password);
                return "OK";
            }else{
                return "PASS";
            }
        }else{
            return "NO";
        }
    }
    @RequestMapping("/updateUserSetup")
    public String updateSetUp(User user, HttpSession session,Map<Object,Object> map){


        boolean name=user.getName().equals(session.getAttribute("username"));
        boolean password=user.getPassword().equals(session.getAttribute("password"));
        boolean email=user.getEmail().equals(session.getAttribute("email"));
        Article article=new Article();
        article.setUserid(user.getUserid());
        article.setUsername(user.getName());
        if(name&&password&&email){
            System.out.println("未作修改");
        }else {
            //修改user表的信息
            userService.updateUser(user);
            //修改article表内关于user的信息
            articleService.updateArticleUsername(article);
            map.put("username",user.getName());
            map.put("password",user.getPassword());
            map.put("email",user.getEmail());

        }
    return "redirect:/userController/getMyself.do";
    }
    @RequestMapping("/getMyself")
    public String getMyselfInfo(HttpSession session,Map<Object,Object> map,Map<Object,Object> map2){
        int userid=(int)session.getAttribute("userid");
        User myInfo=userService.getUserById(userid);
        if(myInfo.getSex()==null){
            myInfo.setSex("保密");
        }
        if(myInfo.getIntro()==null){
            myInfo.setIntro("介绍一下自己吧");
        }
        map.put("myInfo",myInfo);
        //按userid查询帖子信息
        List<Article> myListArticle=articleService.getArticleByUserId(userid);
        //用户的帖子
        map.put("myListArticles",myListArticle);
        for(int i=0;i<myListArticle.size();i++){
            int fid=myListArticle.get(i).getFid();
            commentController.getCommentByFid(fid,map);
            List<Comment> myListComment=(List<Comment>) map.get("myListComment");
            String myListCommentFid="myListComment_"+fid;
            map.put(myListCommentFid,myListComment);
            //用户帖子的评论
            map2.put("map",map);
        }
        //按userid查询评论信息
        List<Comment> myComments=commentService.getCommentByUserid(userid);
        map.put("myComments_huifu",myComments);
        for(int i=0;i<myComments.size();i++){
            int fid=myComments.get(i).getFid();
            Article myArticle=articleService.getArticleKey(fid);
            map.put("myArticle_"+fid,myArticle);
            //回复的帖子
            map2.put("map_huifu",map);
            //根据帖子的id查询用户评论的帖子对应的评论信息
            commentController.getCommentByFid(fid,map);
            List<Comment> myListComment_huifu=(List<Comment>) map.get("listComment");
            String myListCommentFid_huifu_fid="myListComment_huifu_"+fid;
            map.put(myListCommentFid_huifu_fid,myListComment_huifu);
           //回复的帖子的评论
            map2.put("map_huifu_p",map);

        }
        List<Attention> attentions=(List<Attention>) attentionService.getAttention(userid);
        List<User> myListUserAttention=new ArrayList<User>();
        for(Attention attention:attentions){
            int beuserid=attention.getBeuserid();
            myListUserAttention.add(userService.getUserById(beuserid));
        }
        map.put("myListAttentions",myListUserAttention);
        List<Attention> attention_be=attentionService.getAttentionBe(userid);
        List<User> myListUserAttention_be=new ArrayList<User>();
        for(Attention attention:attention_be){
            myListUserAttention_be.add(userService.getUserById(attention.getUserid()));
        }
        map.put("myListAttentions_be",myListUserAttention_be);
        List<Collect> collects=collectService.getCollect(userid);
        List<Article> myListArticleCollect=new ArrayList<Article>();
        for(Collect collect:collects){
            int fid=collect.getFid();
            myListArticleCollect.add(articleService.getArticleKey(fid));
        }
        map.put("myListCollects",myListArticleCollect);

        return "myself";
    }
    //获取他人信息
    @RequestMapping("/getOthers")
    public String getOthersInfo(@RequestParam(value = "userid") int userid, HttpSession session, Map<Object,Object> map, Map<Object,Object> map2){
        //如果该用户是登录用户，则回到“个人主页”
        if(session.getAttribute("userid")!=null && session.getAttribute("userid").equals(userid)) {

            return "redirect:/userController/getMyself.do";
        }else {

            /**
             * 按userid查询用户信息
             */
            User othersListUser = userService.getUserById(userid);
            if (othersListUser.getSex() == null) {
                othersListUser.setSex("保密");
            }
            if (othersListUser.getIntro() == null) {
                othersListUser.setIntro("无");
            }
            map.put("othersListUser", othersListUser);

            /**
             * 按userid查询帖子信息
             */
            List<Article> othersListArticles = articleService.getArticleByUserId(userid);
            map.put("othersListArticles", othersListArticles);

            /**
             * 按fid查询每个帖子下对应的评论信息
             */
            for (int i = 0; i < othersListArticles.size(); i++) {

                // 将每一条帖子对应的id单独抽出来
                int fid = othersListArticles.get(i).getFid();

                // 再通过每一个帖子的id查找出对应的评论信息
                commentController.getCommentByFid(fid,map);
                // 将上一步查出的对应的评论信息存放到listComment里
                List<Comment> othersListComment = (List<Comment>) map.get("listComment");
                System.out.println("othersListComment-"+i+":"+othersListComment);

                // 为map预设一个随帖子id变化而变化的key
                String othersListCommentFid = "othersListComment_" + fid;
                // 将每一个帖子下对应的所有评论存入map中（其key是随帖子id变化而变化的）
                map.put(othersListCommentFid, othersListComment);

                // 再将map存入map2
                map2.put("map", map);
            }

            return "others";
        }
    }
    //无条件查询所有用户
    public void getAllUser(Map<Object,Object> map){
        List<User> listUser=userService.getAllUser();
        map.put("listUser",listUser);
    }
    //退出登录
    @RequestMapping("/userExit")
    public String userExit(Map<Object, Object> map) {

        map.put("userid", "");
        map.put("username", "");
        return "redirect:/index.jsp";// 重定向
    }
    @RequestMapping("/updateUser")
    public ModelAndView updateUserInfo(User user,HttpSession session){

        userService.updateUserzhiliao(user);


        return new ModelAndView("redirect:/userController/getMyself.do");
    }
    //管理员删除用户
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("userid")int userid){
        collectService.deleteCollectByUserid(userid);
        commentService.deleteComment(userid);
        attentionService.deleteAttentionByUserid(userid);
        viaService.deleteVia(userid);
        articleService.deleteArticle(userid);
        userService.deleteUser(userid);
        return "redirect:/admin/index.jsp";
    }
}
