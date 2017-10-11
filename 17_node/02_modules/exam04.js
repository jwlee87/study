/**
 * path : 경로에 대한 다양한 값을 추출
 */
var path = require("path");
var uploadDir = "c:/test/";
var fileName  = "/aa/bb/index.js";

//var filePath = uploadDir + fileName; 
var filePath = path.join(uploadDir, fileName); 
console.log(filePath);

//디렉토리 : /aa/bb
//확장자 : .js
//파일명 : index.js
console.log("디렉토리 : " + path.dirname(fileName));
console.log("확장자 : " + path.extname(fileName));
console.log("파일명 : " + path.basename(fileName));

console.log("파일명 : " + path.basename("aaa.js", ".js"));

var testPath = "c:/a/b/c.js";
var testName = path.basename(testPath, path.extname(testPath));
console.log(testName);









