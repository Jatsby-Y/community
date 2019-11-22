package life.coder.community.cache;

import life.coder.community.dto.TagDTO;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Karl
 * @date 2019年 11月22日 13:42:54
 */
public class TagCache {
    public static List<TagDTO> get() {
        ArrayList<TagDTO> tagDTOS = new ArrayList<>();
        TagDTO programs = new TagDTO();
        programs.setCategoryName("开发语言");
        programs.setTags(Arrays.asList("javascript", "java", "php", "C++", "C", "python", "html", "css", "golang", "node.js"));
        tagDTOS.add(programs);

        TagDTO frameworks = new TagDTO();
        frameworks.setCategoryName("平台框架");
        frameworks.setTags(Arrays.asList("spring", "express", "django", "flask", "koa", "struts"));
        tagDTOS.add(frameworks);

        TagDTO servers = new TagDTO();
        servers.setCategoryName("服务器");
        servers.setTags(Arrays.asList("ngnix", "tomcat", "apache", "linux", "centos", "docker", "ubuntu", "hadoop"));
        tagDTOS.add(servers);

        TagDTO db = new TagDTO();
        db.setCategoryName("数据库");
        db.setTags(Arrays.asList("mysql", "redis", "mongodb", "sql", "oracle", "sqlserver"));
        tagDTOS.add(db);

        TagDTO tools = new TagDTO();
        tools.setCategoryName("开发工具");
        tools.setTags(Arrays.asList("git", "github", "visual-studio-code", "vim", "ide", "eclipse", "maven", "svn"));
        tagDTOS.add(tools);
        return tagDTOS;
    }

    public static String filterInvalid(String tags) {
        String[] split = StringUtils.split(tags, ",");
        List<TagDTO> tagDTOS = get();
        List<String> tagList = tagDTOS.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = Arrays.stream(split).filter(t -> !tagList.contains(t)).collect(Collectors.joining(","));
        return invalid;
    }
}
