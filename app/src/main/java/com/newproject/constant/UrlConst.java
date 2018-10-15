package com.newproject.constant;


/**
 * Created by Administrator on 2016/11/2.
 */
public class UrlConst {


    public static String weixin_APP_ID = "";
    //服务器主地址
    public static String SERVER_ADDRESS = "http://api.app1688.online/";


    //用户接口
    public static String User = SERVER_ADDRESS + "User/";

    //注册
    public static String REGISTER = User + "register";
    //登录
    public static String LOGIN = User + "login";
    //刷新token
    public static String REFRESH_TOKEN = User + "refreshToken";
    //修改昵称
    public static String MODIFY_NAME = User + "nicknameModify";
    //个人信息 没有用户主页接口 所以这个接口没有使用
    public static String USERINFO = User + "userInfo";
    //修改头像
    public static String MODIFY_AVATAR = User + "avatarModify";
    //更换手机号码
    public static String MODIFY_MOBILE = User + "mobileModify";
    //修改密码
    public static String MODIFY_PASS = User + "passModify";
    //忘记密码
    public static String FORGETPASS = User + "forgetPass";
    //扫描二维码
    public static final String SCAN_OR_CODE = User + "scanQrCode";
    //确认登录
    public static final String LOGIN_OR_CODE = User + "loginQrCode";


    //其他 1个接口
    public static String Extras = SERVER_ADDRESS + "Extras/";

    //检验验证码
    public static String CHECK_CODE = Extras + "checkCode";
    //发送短信验证码
    public static String SEND_CODE = Extras + "sendCode";
    //banner
    public static String BANNER = Extras + "banner";
    //上传文件
    public static String UPLOADFILE = Extras + "uploadFile";
    //搜索接口
    public static String SEARCH = Extras + "search";
    //意见反馈
    public static String FEEDBACK = Extras + "feedback";
    //需求快报
    public static String NEWS = Extras + "news";
    //获取版本号
    public static String VERSION = Extras + "version";
    //用户协议
    public static String XIE_YI = Extras + "xieYi";


    //鸟窝
    public static String NEST = SERVER_ADDRESS + "Nest/";

    //七日热门
    public static String HOT = NEST + "hot";
    //发布文章
    public static String ADDNEST = NEST + "addNest";
    //文章列表
    public static String ARTICLE_LIST = NEST + "articleList";
    //文章页
    public static String INFONEST = NEST + "infoNest?nest_id=";
    //发布问答
    public static String ADD_ANSWER = NEST + "addAnswer";
    //问答列表
    public static String NESTLIST = NEST + "nestList";
    //问答详情
    public static String INFOANSWER = NEST + "infoAnswer";
    //文章点赞  这个接口暂时不用
    public static String ZAN_NEST = NEST + "zanNest";
    //问答-评论
    public static String REPLY_NEST = NEST + "replyNest";
    //问答-评论列表
    public static String REPLY_LIST = NEST + "replyList";
    //问答-回复评论
    public static String REPLY_REPLY = NEST + "replyReply";
    //问答-评论点赞
    public static String ZAN_REPLAY = NEST + "zanReply";
    //我的回答列表
    public static String MYREPLEY = NEST + "myReply";
    //我发布的文章
    public static String MYNEST = NEST + "myNest";
    //我发布的问答
    public static String MYANSWER = NEST + "myAnswer";
    //获取问答最新消息状态
    public static String UNREADANSWER = NEST + "unreadAnswer";


    //热不热 4 个接口
    public static String Article = SERVER_ADDRESS + "Article/";
    //文章分类
    public static String CATEGORYLIST = Article + "categoryList";
    //文章列表
    public static String LIST_ARTICLE = Article + "listArticle";
    //文章页
    public static String INFO = Article + "info?id=";
    //树洞
    public static String SHUDONG = Article + "shuDong";
    //糗事
    public static String QIUSHI = Article + "qiuShi";
    //首页热不热
    public static String HOME_ARTICLE = Article + "homeArticle";


    //任务 4 个接口
    public static String Task = SERVER_ADDRESS + "Task/";

    //发布任务
    public static String CREATETASK = Task + "createTask";
    //已发布的任务
    public static String LISTTASK = Task + "listTask";
    //删除发布的任务
    public static String DELTASK = Task + "delTask";
    //修改任务
    public static String MODIFYTASK = Task + "modifyTask";
    //任务大厅
    public static String TASKLIST = Task + "taskList";


    //总共17个接口

}
