// http://expressjs.com/ko/guide/using-middleware.html
// 모듈을 추출합니다.
var express = require('express');

// 서버를 생성합니다.
var app = express();

// 미들웨어를 설정합니다.
app.use(function (request, response, next) {
  // 데이터를 추가합니다.
  console.log('Time:', Date.now());
  request.msg = "hi! ";
  // 다음 미들웨어 호출 
  // 만약, next()를 호출하지 않으면 다음 미들웨어로 진행되지 않기 때문에 화면 출력이 안될 수 있다
  next();
});

app.use(function (request, response, next) {
  // 데이터를 추가합니다.
  console.log("두번째 미들웨어 실행");
  request.msg += " middleware";
  next();
});

app.use(function (request, response, next) {
  console.log("세번째 미들웨어 실행");
  // 응답합니다.
  response.write('<h1>' + request.msg + '</h1>');
  response.end();
});

//서버를 실행합니다.
app.listen(3000, function () {
  console.log('서버 구동됨');
});
