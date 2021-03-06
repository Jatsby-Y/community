
function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    comment2Target(questionId, 1, content);
}

function comment2Target(targetId, type, content) {
    if (!content) {
        alert("回复内容不能为空哦(#^.^#)")
        return;
    }
    $.ajax({
        type: "post",
        url: "/comment",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId": targetId,
            "content": content,
            "type": type
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
            } else {
                if (response.code == 2003) {
                    var sureLogin = confirm(response.message);
                    if (sureLogin) {
                        window.open("https://github.com/login/oauth/authorize?client_id=f55e7ac6857a065b5bd9&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", "sure");
                    }
                } else {
                    alert(response.message);
                }
            }
        },
        dataType: "json"
    });
}

function subComments(e) {
    var commentId = e.getAttribute("data-id");
    var content = $("#input-" + commentId).val();
    comment2Target(commentId, 2, content);

}

 /**
   * 展开二级评论
   * @Param: js的bom元素
   * @Param:
   */
 function collapseComments(e) {
     var id = e.getAttribute("data-id");
     var comments = $("#comment-" + id);
     // 获取二级评论展开状态
     var collapse = e.getAttribute("comment-collapse");
     if (collapse) {
         // 有就折叠
         comments.removeClass("in");
         e.removeAttribute("comment-collapse");
         e.classList.remove("active");
     } else {
         // 展开
         var subCommentContainer = $("#comment-" + id);
         if (subCommentContainer.children().length != 1) {
             comments.addClass("in");
             e.setAttribute("comment-collapse", "in");
             e.classList.add("active");
         } else {
             $.getJSON("/comment/" + id, function (data) {
                 $.each(data.data.reverse(), function (index, comment) {
                     var mediaLeftElement = $("<div/>", {
                         "class": "media-left"
                     }).append($("<img/>", {
                         "class": "media-object img-rounded",
                         "src": comment.user.avatarUrl
                     }));

                     var mediaBodyElement = $("<div/>", {
                         "class": "media-body"
                     }).append($("<h5/>", {
                         "class": "media-heading",
                         "html": comment.user.name
                     })).append($("<div/>", {
                         "html": comment.content
                     })).append($("<div/>", {
                         "class": "menu"
                     }).append($("<span/>", {
                         "class": "pull-right",
                         "html": moment(comment.gmtCreate).format('YYYY-MM-DD HH:mm')
                     })));

                     var mediaElement = $("<div/>", {
                         "class": "media",
                     }).append(mediaLeftElement).append(mediaBodyElement);

                     var commentElement = $("<div/>", {
                         "class": "col-lg-12 col-md-12 col-sm-12 col-xs-12 comments"
                     }).append(mediaElement);
                     subCommentContainer.prepend(commentElement)
                 });
                 comments.addClass("in");
                 e.setAttribute("comment-collapse", "in");
                 e.classList.add("active");
             });
         }
     }
 }
 
 function showSelectTag() {
    $("#select-tag").show();

 }

 function selectTag(e) {
     var value = e.getAttribute("data-tag");
     var previous = $("#tag").val();
     if (previous.indexOf(value) == -1) {
         if (previous) {
             $("#tag").val(previous + ',' + value);
         } else {
             $("#tag").val(value);
         }
     }
 }