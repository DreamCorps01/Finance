/**
 * Created by Dell on 2017/7/8.
 */
var zhoux = {};

zhoux.fromPost = function (url,args,target) {
    args = args || {};
    args._csrf = $("meta[name='_csrf']").attr("content");
    var body = $(document.body),
        form = $("<form method='post'></form>"),
        input;
    if (target != null){
        form.attr("target", target);
    }

    form.attr({"action": url});
    $.each(args, function (key, value) {
        input = $("<input type='hidden'>");
        input.attr({"name": key});
        input.val(value);
        form.append(input);
    });
    form.appendTo(document.body);
    form.submit();
    document.body.removeChild(form[0]);
};
zhoux.post = function (url, params, callback, type, async, processData,unmask) {
    var header = $("meta[name='_csrf_header']").attr("content");
    var token = $("meta[name='_csrf']").attr("content");
    alert(params)
    $.ajax({
        url: url,
        processData: processData != undefined ? processData : true,
        data: params,
        success: callback,
        traditional: true,
        type: "POST",
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        dataType: type ? type : "json",
        async: false,
        error: function (data, type) {
            if (unmask) {
                unmask()
            }

        }
    });
};