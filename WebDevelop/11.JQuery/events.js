$(function() {
    var b = true;
    var rows = 0;
    var id = 0;
    $("[value=新增]").click(function() {
        //var name = prompt("请输入您的名字", "");
        // if (name) {
        //     alert("欢迎您：" + name)
        // }
        $(":text").val("");
        $("select option:first").attr("selected", "selected");
        $("#d2").show();
    });

    $("[value=修改]").live("click", function() {
        $("#d2").show();
        b = false;
        rows = $(this).parents("tr").index();
        id = $(this).parents("tr").children("td:eq(0)").text();
        var ti = $(this).parents("tr").children("td:eq(1)").text();
        var ab = $(this).parents("tr").children("td:eq(2)").text();
        var au = $(this).parents("tr").children("td:eq(3)").text();
        var ty = $(this).parents("tr").children("td:eq(4)").text();
        $("#ti").val(ti);
        $("#ab").val(ab);
        $("#au").val(au);
        $("option:selected").text(ty);
    })

    $("[value=保存]").click(function() {
        var title = $("#ti").val();
        var abstract = $("#ab").val();
        var author = $("#au").val();
        var type = $("option:selected").text();
        if (b) {
            id = parseInt($("table tr:last td:eq(0)").text()) + 1;
            $("table").append("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
            rows = $("table tr").length - 1;
            if (rows == 1) {
                id = rows;
            }
        }
        $("table tr:eq(" + rows + ") td:eq(0)").text(id);
        $("table tr:eq(" + rows + ") td:eq(1)").text(title);
        $("table tr:eq(" + rows + ") td:eq(2)").text(abstract);
        $("table tr:eq(" + rows + ") td:eq(3)").text(author);
        $("table tr:eq(" + rows + ") td:eq(4)").text(type);
        $("table tr:eq(" + rows + ") td:eq(5)").html("<input type='button' value='修改'>&nbsp;&nbsp;&nbsp;<input type='button' value='删除'>");
        $("#d2").hide();
        b = true;
    })

    $("[value=删除]").live("click", function() {
        $(this).parents("tr").remove();
    })
})