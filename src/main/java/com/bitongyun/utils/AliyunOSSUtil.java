package com.bitongyun.utils;


import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.bitongyun.constvalue.ConstValue;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
 
/**
 * Created by lightClouds917
 * Date 2018/2/7
 * Description:aliyunOSSUtil
 */
public class AliyunOSSUtil {
 

    public static String upload(File file){
        String endpoint=ConstValue.ENDPOINT;
        String accessKeyId=ConstValue.ACCESSKEYID;
        String accessKeySecret=ConstValue.ACCESSKEYSECRET;
        String bucketName=ConstValue.BUCKETNAME;
        //这儿可以按照用户名来创建相应文件
        String fileHost=ConstValue.FILEHOST;
 
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date());
 
 
        OSSClient ossClient = new OSSClient(endpoint,accessKeyId,accessKeySecret);
        try {
            //容器不存在，就创建
            if(! ossClient.doesBucketExist(bucketName)){
                ossClient.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                ossClient.createBucket(createBucketRequest);
            }
            //创建文件路径
            String fileUrl = fileHost+"/"+(dateStr + "/" + UUID.randomUUID().toString().replace("-","")+"-"+file.getName());
            //上传文件
            PutObjectResult result = ossClient.putObject(new PutObjectRequest(bucketName, fileUrl, file));
            //设置权限 这里是公开读
            ossClient.setBucketAcl(bucketName,CannedAccessControlList.PublicRead);
            if(null != result){
                return fileUrl;
            }
        }catch (OSSException oe){
            System.out.println(oe.getMessage());
        }catch (ClientException ce){
            System.out.println(ce.getMessage());
        }finally { 
            //关闭
            ossClient.shutdown();
        } 
        return null; 
    }
    
    //可以实现批量删除，后面再说
    public static Boolean delet(String fileName) {
        String endpoint=ConstValue.ENDPOINT;
        String accessKeyId=ConstValue.ACCESSKEYID;
        String accessKeySecret=ConstValue.ACCESSKEYSECRET;
        String bucketName=ConstValue.BUCKETNAME;
        OSSClient ossClient = new OSSClient(endpoint,accessKeyId,accessKeySecret);
        ossClient.deleteObject(bucketName, fileName);
        System.out.println("删除Object：" + fileName + "成功。");
        //判断是否删除成功，但是应该比较慢，看能否替换
        boolean found = ossClient.doesObjectExist(bucketName, fileName);
        // 关闭OSSClient。
        ossClient.shutdown();
        return found;
    }
}


