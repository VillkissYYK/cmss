package edu.ynmd.cms.action;

import edu.ynmd.cms.model.Carousel;
import edu.ynmd.cms.model.News;
import edu.ynmd.cms.model.Singlepage;
import edu.ynmd.cms.service.ManageService;
import edu.ynmd.cms.tools.OssTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("manage")
public class AdminAction {

    @Autowired
    private ManageService manageService;


    @PostMapping("addNews")
    @ResponseBody
    public boolean addNews(@RequestBody News news) throws Exception{
        news.setPbdate(System.currentTimeMillis());
        return manageService.addNews(news);

    }


    @PostMapping("deleteNews")
    @ResponseBody
    public boolean deleteNews(@RequestBody News news) throws Exception {
        return manageService.deletenews(news.getNewsid());
    }

    @PostMapping("updateNews")
    @ResponseBody
    public boolean updateNews(@RequestBody News news) throws Exception {
        return manageService.updateNews(news);
    }


    @PostMapping("getSingleNews")
    @ResponseBody
    public News getSingleNews(@RequestBody News news) throws Exception {

        return manageService.getNews(news.getNewsid());
    }


    @GetMapping("getNewsList")
    @ResponseBody
    public List<News> getNewsList() throws Exception {

        return manageService.getNewsList();
    }


    @PostMapping("uploadNewsCoverpic")
    @ResponseBody
    public HashMap uploadNewsCoverpic(MultipartFile file, HttpServletRequest request) throws Exception{
       HashMap m = new HashMap();
        String filename= file.getOriginalFilename();
        String newsid =request.getHeader("newsid");//将newsid放在http header

        int index=filename.lastIndexOf(".");
        String suffexname=filename.substring(index);
        String tosavefilename=String.valueOf(System.currentTimeMillis())+suffexname;


        //检测上传文件目录是否存在
//        String savepath="sss";
        String savepath="/root/project/picupload/";
//        String savepath="D:\\springbootupload\\";
        File f=new File(savepath);
        if(!f.exists()){
            f.mkdir();
        }
        //将上传的文件保存到该文件加下
//        file.transferTo(new File(savepath+tosavefilename));
        String savefile = savepath + filename;
        File touploadfile = new File(savefile);
        file.transferTo(touploadfile);

        OssTools ossTools = new OssTools();
        ossTools.init();

        String osspath = "/carousel/" + tosavefilename;
        String result = ossTools.uploadFireForUrl(osspath, touploadfile);
        System.out.println("上传文件的结果" + result);
        String osshost = "https://cms-1259343601.cos.ap-chengdu.myqcloud.com/carousel/";
        tosavefilename = osshost+tosavefilename;



//        将上传的图片地址保存到数据库中
        News toupdatenews=manageService.getNews(newsid);
        if(toupdatenews!=null){
            toupdatenews.setCoverpic(tosavefilename);
            manageService.updateNews(toupdatenews);

        }


        m.put("filename",tosavefilename);
        m.put("newsid",newsid);

        return m;
    }



//    @PostMapping("fileUpload")
//    @ResponseBody
//    public Map fileUpload(MultipartFile file) throws Exception {
//        String filename=file.getOriginalFilename();
//        System.out.printf("接收到的文件名是 "+filename);
//        //获得文件的后缀
//        int index=filename.lastIndexOf(".");
//        String suffexname=filename.substring(index);
//        String tosavefilename=String.valueOf(System.currentTimeMillis())+suffexname;
//
//
//        //检测上传文件目录是否存在
////        String savepath="sss";
//        String savepath="/root/project/picupload/";
////        String savepath="D:\\springbootupload\\";
//        File f=new File(savepath);
//        if(!f.exists()){
//            f.mkdir();
//        }
//        //将上传的文件保存到该文件加下
//        file.transferTo(new File(savepath+tosavefilename));
//        Map m=new HashMap();
//        m.put("pic",tosavefilename);
//        return m;
//    }


    @PostMapping("fileUpload")
    @ResponseBody
    public Map fileUpload(MultipartFile file) throws Exception {
        Map m = new HashMap();
        String filename = file.getOriginalFilename();
        System.out.printf("接收到的文件名是 " + filename);
        //获得文件的后缀
        int index = filename.lastIndexOf(".");
        String suffexname = filename.substring(index);
        String tosavefilename = String.valueOf(System.currentTimeMillis()) + suffexname;


        //检测上传文件目录是否存在
//        String savepath="sss";
        String savepath = "/root/project/picupload/";
//        String savepath="D:\\springbootupload\\";
        File f = new File(savepath);
        if (!f.exists()) {
            f.mkdir();
        }
        //将上传的文件保存到该文件加下
//        file.transferTo(new File(savepath+tosavefilename));
//        Map m=new HashMap();
//        m.put("pic",tosavefilename);
//        return m;
        String savefile = savepath + filename;
        File touploadfile = new File(savefile);
        file.transferTo(touploadfile);

        OssTools ossTools = new OssTools();
        ossTools.init();

        String osspath = "/carousel/" + tosavefilename;
        String result = ossTools.uploadFireForUrl(osspath, touploadfile);
        System.out.println("上传文件的结果" + result);

        String osshost = "https://cms-1259343601.cos.ap-chengdu.myqcloud.com/carousel/";
        String url = osshost + tosavefilename;
        m.put("pic", url);
        return m;
    }






//    @PostMapping("tofileUpload")
//    @ResponseBody
//    public Map tofileUpload(MultipartFile file) throws Exception {
//        String filename=file.getOriginalFilename();
//        System.out.printf("接收到的文件名是 "+filename);
//        //获得文件的猴嘴
//        int index=filename.lastIndexOf(".");
//        String suffexname=filename.substring(index);
//        String tosavefilename=String.valueOf(System.currentTimeMillis())+suffexname;
//
//
//        //检测上传文件目录是否存在
//        String savepath="/root/project/picupload/";
////        String savepath="sss";
////        String savepath="D:\\springbootupload\\";
//        File f=new File(savepath);
//        if(!f.exists()){
//            f.mkdir();
//        }
//        //将上传的文件保存到该文件加下
//        file.transferTo(new File(savepath+tosavefilename));
//        Map m=new HashMap();
//        m.put("img",tosavefilename);
//        return m;
//    }

    @PostMapping("tofileUpload")
    @ResponseBody
    public Map tofileUpload(MultipartFile file) throws Exception {
        Map m = new HashMap();
        String filename = file.getOriginalFilename();
        System.out.printf("接收到的文件名是 " + filename);
        //获得文件的后缀
        int index = filename.lastIndexOf(".");
        String suffexname = filename.substring(index);
        String tosavefilename = String.valueOf(System.currentTimeMillis()) + suffexname;


        //检测上传文件目录是否存在
//        String savepath="sss";
        String savepath = "/root/project/picupload/";
//        String savepath="D:\\springbootupload\\";
        File f = new File(savepath);
        if (!f.exists()) {
            f.mkdir();
        }
        //将上传的文件保存到该文件加下
//        file.transferTo(new File(savepath+tosavefilename));
//        Map m=new HashMap();
//        m.put("pic",tosavefilename);
//        return m;
        String savefile = savepath + filename;
        File touploadfile = new File(savefile);
        file.transferTo(touploadfile);

        OssTools ossTools = new OssTools();
        ossTools.init();

        String osspath = "/single/" + tosavefilename;
        String result = ossTools.uploadFireForUrl(osspath, touploadfile);
        System.out.println("上传文件的结果" + result);

        String osshost = "https://cms-1259343601.cos.ap-chengdu.myqcloud.com/single/";
        String url = osshost + tosavefilename;
        m.put("img", url);
        return m;
    }



//    @RequestMapping("/ckeditorUpload")
//    @ResponseBody
//
//    public String ckeditorUpload(@RequestParam("upload") MultipartFile file, String CKEditorFuncNum) throws Exception {
//
//        if (!file.isEmpty()) {
//            String finename = file.getOriginalFilename();
//            String suffixname = file.getOriginalFilename().substring(finename.lastIndexOf("."));
//
//            finename = String.valueOf(System.currentTimeMillis()) + suffixname;
//
////            String filepath = "/root/project/picupload/";
//            String filepath = "D:\\springbootupload\\";
//
//            File tf = new File(filepath);
//            if (!tf.exists()) {
//                tf.mkdir();
//            }
//            String savefile = filepath + finename;
//            try {
//                file.transferTo(new File(savefile));



//
//
//                String url = "https://localhost/public/" + finename;
//
//                return "{\"uploaded\":1,\"fileName\":\"" + savefile + "\",\"url\":\"" + url + "\"}";
//
//            } catch (IOException e) {
//                e.printStackTrace();
//                return "{\"uploaded\":0,\"error\":{\"message\":\"upload file is not success!\"}}";
//
//            } catch (IllegalStateException e) {
//                e.printStackTrace();
//                return "{\"uploaded\":0,\"error\":{\"message\":\"upload file is not success!\"}}";
//
//            }
//
//
//        }
//
//
//        return "{\"uploaded\":0,\"error\":{\"message\":\"upload file is not success!\"}}";
//    }

    @RequestMapping("/ckeditorUpload")
    @ResponseBody

    public String ckeditorUpload(@RequestParam("upload") MultipartFile file, String CKEditorFuncNum) throws Exception {

        if (!file.isEmpty()) {
            String finename=file.getOriginalFilename();
            String suffixname=file.getOriginalFilename().substring(finename.lastIndexOf("."));

            finename=String.valueOf(System.currentTimeMillis())+suffixname;

            String filepath="/root/project/picupload/";
//            String filepath="D:\\springbootupload\\";

            File tf=new File(filepath);
            if(!tf.exists()){
                tf.mkdir();
            }
            String savefile=filepath+finename;
            try {

                File touploadfile=new File(savefile);
                file.transferTo(touploadfile);

                OssTools ossTools =new OssTools();
                ossTools.init();
                String osspath="/news/"+finename;

                String result= ossTools.uploadFireForUrl(osspath,touploadfile);
//                String result= ossTools.uploadFireForUrl(filename,touploadfile);

                System.out.println("上传文件的结果"+result);

                // String url="https://localhost/public/"+finename;

                String osshost="https://cms-1259343601.cos.ap-chengdu.myqcloud.com/news/";
                String url =osshost+finename;



//                return "{\"uploaded\":1,\"fileName\":\""+savefile+"\",\"url\":\"" + url + "\"}";
                return "{\"uploaded\":1,\"url\":\"" + url + "\"}";

            } catch (IOException e) {
                e.printStackTrace();
                return "{\"uploaded\":0,\"error\":{\"message\":\"upload file is not success!\"}}";

            } catch (IllegalStateException e) {
                e.printStackTrace();
                return "{\"uploaded\":0,\"error\":{\"message\":\"upload file is not success!\"}}";

            }



        }


        return "{\"uploaded\":0,\"error\":{\"message\":\"upload file is not success!\"}}";
    }







    @PostMapping("addCarousel")
    @ResponseBody
    public boolean addCarousel(@RequestBody Carousel carousel) throws Exception{
        return manageService.addCarousel(carousel);
    }

    @GetMapping("getCarouselList")
    @ResponseBody
    public  List<Carousel> getCarouselList() throws Exception{
        return manageService.getCarouselList();
    }

    @PostMapping("deleteCarousel")
    @ResponseBody
    public boolean deleteCarousel(@RequestBody Carousel carousel)throws Exception {
        return manageService.deleteCarousel(carousel.getCarouselid());
    }

    @PostMapping("updateCarousel")
    @ResponseBody
    public boolean updateCarousel(@RequestBody Carousel carousel)throws Exception {
        return manageService.updateCarousel(carousel);
    }

    @PostMapping("getSingleCarousel")
    @ResponseBody
    public Carousel getSingleCarousel(@RequestBody Carousel carousel)throws Exception {
        return manageService.getCarousel(carousel.getCarouselid());
    }

    @PostMapping("addSinglepage")
    @ResponseBody
    public boolean Singlepage(@RequestBody Singlepage singlepage) throws  Exception{
        return  manageService.addSinglepage(singlepage);
    }

    @GetMapping("getSinglepageList")
    @ResponseBody
    public List<Singlepage> getSinglepageList() throws Exception{
        return  manageService.getSinglepageList();
    }

    @PostMapping("deleteSinglepage")
    @ResponseBody
    public boolean deleteSinglepage(@RequestBody Singlepage singlepage)throws Exception{
        return  manageService.deleteSinglepage(singlepage.getSinglepageid());
    }

    @PostMapping("updateSinglepage")
    @ResponseBody
    public  boolean updateSinglepage(@RequestBody Singlepage singlepage)throws Exception{
        return  manageService.updateSinglepage(singlepage);
    }

    @PostMapping("getSinglepage")
    @ResponseBody
    public  Singlepage getSinglepage(@RequestBody Singlepage singlepage)throws Exception{
        return manageService.getSinglepage(singlepage.getSinglepageid());
    }
}
