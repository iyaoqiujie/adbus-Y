# adbus-Y
This project is part of the whole adbus project.

提供接口如下描述。
设计单接口:
1.  /dsheet/all    --获取所有设计单
2.  /dsheet/allByContract  -- 获取某一个合同号下所有设计单
    eg: http://busme.cn:<端口>/adbusY/dsheet/allByContract?contractId=12345
3.  /dsheet/oneDS    -- 获取单个设计单
    eg: http://busme.cn:<端口>/adbusY/dsheet/oneDS?dsId=1
4.  /dsheet/dsmain     -- 获取设计单基本信息
    eg: http://busme.cn:<端口>/adbusY/dsheet/dsmain?dsId=1
5.  /dsheet/dsbusline  -- 获取设计单车辆线路信息
    eg: http://busme.cn:<端口>/adbusY/dsheet/dsbusline?dsId=1
6.  /dsheet/createDS   -- 基于合同号创建一个设计单
    eg:
    function createDS() {
        var dsData = { "contractId":23456 };
        $.ajax({
            type:"POST",
            url:"dsheet/createDS",
            dataType:"json",
            contentType:"application/json",
            data:JSON.stringify(dsData),
            success:function(data){
                }
            });
    }
7.  /dsheet/updateDSMain  -- 创建或者修改设计单基本信心
    eg:
    function updateDSMain() {
        var myDSheet = {"id":2 };
        var data = {"contractCode":"ABCD", "salesMan":"宋佩", "customer":"肯德基", "company":"自营中心",
            "adContent":"肯德基好吃", "busNum":100, "auditPicCount":3, "designType":1, "requirements":"图片要大"};
        data.designSheet = myDSheet;
        $.ajax({
                type:"POST",
                url:"dsheet/updateDSMain",
                dataType:"json",
                contentType:"application/json",
                data:JSON.stringify(data),
                success:function(data){
                }
            });
    }
8.  /dsheet/batchInsertDSBusLine  -- 为某个设计单下批量插入车辆线路信息
    eg:
    function batchInsert() {
            var myDSheet = {"id":5, "contractId":123}
            var saveDataAry=[];
            var data1={"line":"11", "level":"A++", "type":"双层车", "count":16, "frequencyByDay":60, "comments":"同意", "operator":"毛主席"};
            data1.designSheet=myDSheet;
            var data2={"line":"22", "level":"A", "type":"单层车", "count":30, "frequencyByDay":60, "comments":"同意", "operator":"胡主席"};
            data2.designSheet=myDSheet;
            saveDataAry.push(data1);
            saveDataAry.push(data2);
            $.ajax({
                type:"POST",
                url:"dsheet/batchInsertDSBusLine",
                dataType:"json",
                contentType:"application/json",
                data:JSON.stringify(saveDataAry),
                success:function(data){
                    alert(eval(data));
                }
            });
    }
9.  /dsheet/updateDSBusLine  -- 修改单条车辆线路信息
    eg:
    function updateDSBusLine() {
            var myDSheet = {"id": 5 }
            var data1={"id":6, "line":"256", "level":"A++", "type":"双层车", "count":90, "frequencyByDay":100, "comments":"同意", "operator":"路飞"};
            data1.designSheet=myDSheet;
            $.ajax({
                type:"POST",
                url:"dsheet/updateDSBusLine",
                dataType:"json",
                contentType:"application/json",
                data:JSON.stringify(data1),
                success:function(data){
                    alert(eval(data));
                }
            });
    }
10. /dsheet/deleteDSBusLine  --  删除单条车辆线路信息
    eg:
    function delDSBusLine() {
            var data1={"id":3 };
            $.ajax({
                type:"POST",
                url:"dsheet/deleteDSBusLine",
                dataType:"json",
                contentType:"application/json",
                data:JSON.stringify(data1),
                success:function(data){
                    alert(eval(data));
                }
            });
    }
