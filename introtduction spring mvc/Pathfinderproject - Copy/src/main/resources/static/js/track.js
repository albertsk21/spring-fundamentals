

const postBtn = document.getElementById('postComment');

const host = 'http://localhost:8080';
postBtn.addEventListener('click',(event)=>{
    event.preventDefault();

    const textContent = document.getElementById("message").textContent;
    const currentUrl = window.location.href.split("/")
    const routeId = currentUrl[currentUrl.length - 1];

    const options = {
        method : 'POST',
        headers : {},
        body : JSON.stringify({textContent})
    }
    options.headers['Content-type'] = 'applications/json';

    fetch(host + '/api/comments/' + routeId, options);
    window.location.replace(host + '/routes/details/1');

});

