
setTimeout(weatherRunner,100);


function weatherRunner(){

    let boxImgA = document.getElementById('box-a-img');
    let boxImgB = document.getElementById('box-b-img');
    let boxTempA = document.getElementById('box-a-temp');
    let boxTempB = document.getElementById('box-b-temp');


    let titleBoxA = document.getElementsByClassName("top-box-a")[0].getElementsByTagName("h4")[0];
    titleBoxA.innerText = 'Weather in Berlin';

    let titleBoxB = document.getElementsByClassName("top-box-b")[0].getElementsByTagName("h4")[0];
    titleBoxB.innerText = 'Weather in London';

    fetch("https://api.openweathermap.org/data/2.5/weather?q=Berlin&appid=8dd1b8c6c70655b59ef4f75b4d9fb753")
        .then(data => data.json())
        .then(info => {
            //Formula Kelvin to Celsius 299K − 272.15 = 25.85°C
            boxTempA.innerText = Math.round(info.main.temp - 272.15);
            boxImgA.src = '/images/weather-icons/' + info.weather[0].icon + '.png';
        });

    fetch("http://api.openweathermap.org/data/2.5/weather?q=London&appid=8dd1b8c6c70655b59ef4f75b4d9fb753")
        .then(data => data.json())
        .then(info => {
            //Formula Kelvin to Celsius 299K − 272.15 = 25.85°C
            boxTempB.innerText = Math.round(info.main.temp - 272.15);
            boxImgB.src = '/images/weather-icons/' + info.weather[0].icon + '.png';
        });
}