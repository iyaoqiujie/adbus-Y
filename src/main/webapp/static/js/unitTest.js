// 备注 ajax请求不能加 contentType参数
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

function updateDSMain() {
    var myDSheet = {"id":2 };
    var data = {"contractCode":"ABCDDDDDD", "salesMan":"宋佩", "customer":"肯德基", "company":"自营中心",
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
function delDSBusLine() {
        var data1={"id":6 };
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
function auditDS() {
        //var myDSheet = {"id": 5 }    // 部门

        //var data1={"department":"媒介", "auditor":"李明", "comments":"同意", "approved":true};
    // var data1={"department":"自营", "auditor":"小红", "comments":"同意", "approved":true};
    var data1={"department":"设计", "auditor":"小杰", "comments":"瞎搞", "approved":false};
        //data1.designSheet=myDSheet;
        $.ajax({
            type:"POST",
            url:"dsheet/auditDS",
            dataType:"json",
            contentType:"application/json",
            data:JSON.stringify(data1),
            success:function(data){
                alert(data["result"]);
            }
        });
}
