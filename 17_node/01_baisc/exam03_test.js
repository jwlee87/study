/**
 * require에 찾는 파일의 확장자가 없을 경우
 * 1. 파일명에 .js가 붙은 파일을 찾는다.
 * 2. 만약, 파일이 없다면 이름에 해당하는 디렉토리를 찾는다.
 *    디렉토리가 존재하면 그 안에서 index.js 파일을 찾는다.
 */
var msg = require("./exam04");
var cal = require("./exam03.js");
console.log("add : " + cal.add(12, 12));
console.log("sub : " + cal.sub(24, 12));
console.log("msg : " + msg);