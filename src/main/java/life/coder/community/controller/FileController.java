package life.coder.community.controller;

import life.coder.community.dto.FileDTO;
import life.coder.community.exception.CustomizeErrorCode;
import life.coder.community.exception.CustomizeException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author Karl
 * @date 2019年 11月22日 22:37:55
 */
@Controller
public class FileController {
    @ResponseBody
    @RequestMapping("/file/upload")
    public FileDTO upload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("editormd-image-file");
        String originalFilename = file.getOriginalFilename();
        String[] split = originalFilename.split("\\.");
        String fileType = split[split.length - 1];
        if (fileType != null) {
            if ("GIF".equals(fileType.toUpperCase())|| "PNG".equals(fileType.toUpperCase())|| "JPG".equals(fileType.toUpperCase())) {
                String trueFileName = String.valueOf(System.currentTimeMillis()) + "." + fileType;
//                    String resourcesPath = ResourceUtils.getURL("classpath:").getPath();
//                    String realPath = resourcesPath + "static/images/" + trueFileName;
                String realPath = "D://Myjava/upload/" + trueFileName;
                String basePath = request.getScheme()+"://"+request.getServerName()+":"+
                        request.getServerPort();
                String fileUrl = basePath + "/upload/" + trueFileName;
                try {
                    file.transferTo(new File(realPath));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                FileDTO fileDTO = new FileDTO();
                fileDTO.setSuccess(1);
//              fileDTO.setUrl("/images/" + trueFileName);
                fileDTO.setUrl(fileUrl);
                return fileDTO;
            } else {
                throw new CustomizeException(CustomizeErrorCode.PICTURE_TYPE_WRONG);
            }
        }
        throw new CustomizeException(CustomizeErrorCode.UPLOAD_FAIL);
    }
}
