package com.pcitc.es.test;

import com.pcitc.es.clientmanager.ClientFactoryBuilder;
import com.pcitc.es.clientmanager.IndexHelperBuilder;
import com.pcitc.service.doc.AccessorService;
import com.pcitc.service.doc.IndexAccessorService;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author:Administrator
 * @date:2018/6/23
 */
public class TestIndex {

    public static void main(String[] args) {
    	
    	String authorization = String.format("{0}:{1}", "AwardsClientTest", "wangcong382.slyt");
    	System.out.println("===="+authorization);

//        SearchUtil.getMappingXContentBuilder(TestModel.class);

        /*//创建连接 链接方式1
        AccessorService accessor = new ClientFactoryBuilder
                .Builder()
                .setCLUSTER_NAME("elasticsearch")//es别名
                .setCLIENT_PORT("9300")//es 端口
                .setHOSTS(new ArrayList<>(Arrays.asList("127.0.0.1"))) //es 地址
                .create();

        //创建连接 链接方式2
//        AccessorService accessor2 = new ClientFactoryBuilder
//                .Config()
//                .setConfigPath("elasticsearch.properties")
//                .initConfig(true)
//                .createByConfig();

        //构建indexhelper
        IndexAccessorService indexAccessor = new IndexHelperBuilder
                .Builder()
                .withClient(accessor.getClient())
                .creatAccessor();


        //创建索引 mapping 和setting
        //通过model 生成index mapping  和setting
        indexAccessor.deleteIndex("files");
//        boolean b = indexAccessor.hasIndex("testindex");
//        System.out.println(b);
        //是否存在mapping
//        boolean b = indexAccessor.hasMapping(TestModel.class);
//        System.out.println(b);
//        boolean flag = indexAccessor.createIndexWithSettings(SysFile.class);
//        indexAccessor.createMappingXContentBuilder(SysFile.class);
//        //        accessor.delete(model.getPost_id()+"",TestModel.class);
//        SysFile model = new SysFile();
//        model.setBak4("中华人民共和国");
//        model.setEsId(1);
//        boolean flagAdd = accessor.add(model);


        //添加多条数据、
//        List<TestModel> testModelList = new ArrayList<>();
//        for (int i = 0; i <= 10; i++) {
//            TestModel model2 = new TestModel();
//            model2.setPost_id(i); //主键不要重复 重复的做updata操作
//            model2.setCreatetime(new Date().toString());
//            model2.setIs_delete(1);
//            model2.setPost_title("测试啊");
//            testModelList.add(model2);
//        }
//        boolean flagAddList = accessor.add(testModelList);
//        //删除一条 id 为1的数据
//        accessor.delete("1", TestModel.class);
        //详情见AccessorService 接口
*/    }

}
