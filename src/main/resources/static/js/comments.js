const routeId = document.getElementById('routeId').value
const commentFrom = document.getElementById('commentForm')
commentFrom.addEventListener("submit",handlerFormSubmission)

const csrfHeaderName = document.head.querySelector('[name=_csrf_header]').content
const csrfHeaderValue = document.head.querySelector('[name=_csrf]').content

const commentControler = document.getElementById('commentCtnr')

async function handlerFormSubmission(event){
    event.preventDefault()

    const messageVal = document.getElementById('message').value

    fetch('http://localhost:8080/api/${routeId}/comments',{
    method: 'POST',
    headers: {
            'Content-Type': 'application/json',
            'Accepts': 'application/json',
            [csrfHeaderName]: csrfHeaderValue
    },
    body: JSON.stringify({
        message: messageVal

    })
}).then(res=> res.json())
.then(data=>{
    document.getElementById('message').value= ""
    commentContainer.innerHTML += commentAsHtml(data)

})
}
function commentAsHtml(comment){
let commentHtml = 'div\n'
commentHtml += '<h4>${comment.authorName}</h4>\n'
commentHtml += '<p>${comment.message)</p>\n'
commentHtml += '</div>\n'
return commentHtml
}

fetch('http://localhost:8080/api/${routeId)/comments',{
    headers: {
        "Accept": "application/json"
    }
}).then(res => res.json())
    .then(data => {
        for(let comment of data){
            commentContainer.innerHtml += commentAsHtml(comment)
        }
    })
