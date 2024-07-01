package generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * 静态代码生成器
 */
public class StaticGenerator {
    public static void main(String[] args) {
//        获取项目的根路径
        String projectPath = System.getProperty("user.dir");
//        输入路径
        String inputPath=projectPath+File.separator+"dja-generator-demo-projects"+ File.separator+"acm-template";
        String outputPath=projectPath;
        copyFilesByHutool(inputPath,outputPath);
    }

    /**
     * 拷贝文件(基于hutool实现 会将输入目录完整的拷贝到输出目录下)
     * @param inputPath  输入路径
     * @param outputPath  输出路径
     */
    public static void copyFilesByHutool(String inputPath, String outputPath){
        FileUtil.copy(inputPath,outputPath,false);
    }
}
