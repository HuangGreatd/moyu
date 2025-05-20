package com.juzipi;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.juzipi.domain.entity.User;
import com.juzipi.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import java.util.HashMap;
import java.util.List;

/**
 * @author juzipi
 * @date 2024/7/21 20:55
 */
@SpringBootTest(classes = MainApplication.class)
@RunWith(SpringRunner.class)
public class MainApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        String userAccount = "小张";
        List<User> userList = userMapper.selectListUser("小明");

        for (User user : userList) {
            System.out.println("user = " + user);
        }

    }


    @Test
    public void test_crawel() {
        String url = "http://search.people.cn/search-platform/front/search"; // 去除 URL 末尾空格

        // 构造 JSON 请求体
        JSONObject paramJson = new JSONObject();
        paramJson.put("key", "遇龙河");
        paramJson.put("isFuzzy", false);
        paramJson.put("hasContent", true);
        paramJson.put("hasTitle", true);
        paramJson.put("page", 1);
        paramJson.put("limit", 10);
        paramJson.put("startTime", 0);
        paramJson.put("endTime", 0);
        paramJson.put("type", 0); // cURL 中存在但 Java 代码缺失的参数
        paramJson.put("sortType", 0); // cURL 中存在但 Java 代码缺失的参数

        // 配置请求头（包含 Cookie、Accept-Encoding 等）
        HttpResponse response = HttpRequest.post(url)
                .header(Header.CONTENT_TYPE, "application/json")
                .header(Header.USER_AGENT, "PostmanRuntime-ApipostRuntime/1.1.0") // 模拟 cURL 的 User-Agent
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive")
                .header("Cookie", "__jsluid_h=e296c413c0c849cf03f1576c0533e5fa") // 添加 Cookie
                .body(String.valueOf(paramJson)) // 发送 JSON 格式的请求体
                .execute();

        // 处理响应
        if (response.isOk()) {
            String result = response.body();
            System.out.println("result = " + result);
        } else {
            System.out.println("请求失败，状态码：" + response.getStatus());
        }
    }


}
