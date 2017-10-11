/**
 *  jquery.js 라이브러리의 일부 기능을 구현해본다.
 */
function mlec(val) {
	// <h1>
	var ch = val.charAt(0);
	console.log("val tagName", val.substring(1, val.length -1));
	var elements;
	switch (ch) {
		case "<":
			elements = document.createElement(val.substring(1, val.length -1));
			break;
		case "#":
			elements = document.querySelector(val);
			break;
		default:
			elements = document.querySelectorAll(val);
			break;
	}
	
	/*
		var pArr = document.querySelectorAll("p");
		for (var i = 0; i < pArr.length; i++) {
			pArr[i].innerHTML = "동적변경";
		}
		
		$("p").html("동적변경");	
	 */
	elements.html = function (html) {
		
		if (this.length) {
			// 값이 넘어 왔다면 설정
			if (html != undefined) {
				for (var i = 0; i < this.length; i++) {
					this[i].innerHTML = html;
				}
				return this;
			}
			// 값이 undefined 존재하지 않는다면 추출
			return this[0].innerHTML;
		}
		else {
			if (html != undefined) {
				this.innerHTML = html;
				return this;
			}
			return this.innerHTML;
		}
	};
	elements.text = function (text) {
		
		if (this.length) {
			// 값이 넘어 왔다면 설정
			if (text != undefined) {
				for (var i = 0; i < this.length; i++) {
					this[i].innerText = text;
				}
				return this;
			}
			// 값이 undefined 존재하지 않는다면 추출
			return this[0].innerText;
		}
		else {
			if (text != undefined) {
				this.innerText = text;
				return this;
			}
			return this.innerText;
		}
	};
	elements.val = function (value) {
		
		if (this.length) {
			// 값이 넘어 왔다면 설정
			if (value != undefined) {
				for (var i = 0; i < this.length; i++) {
					this[i].value = value;
				}
				return this;
			}
			// 값이 undefined 존재하지 않는다면 추출
			return this[0].value;
		}
		else {
			if (value != undefined) {
				this.value = value;
				return this;
			}
			return this.value;
		}
	};
	elements.attr = function (key, value) {
		// key가 {} 형태인 경우의 처리
		// value 매개변수 존재하지 않는다, 설정 파트만 존재
		// {"mymsg": "aaa", "title": "연습중.."}
		if (typeof (key) == "object") {
			if (this.length) {
				for (var i = 0; i < this.length; i++) {
					for (var k in key) {
						this[i].setAttribute(k, key[k]);
					}
				}
				return this;
			}
			else {
				for (var k in key) {
					this.setAttribute(k, key[k]);
				}
				return this;
			}			
		} 
		else {
			if (this.length) {
				// 값이 넘어 왔다면 설정
				if (value != undefined) {
					for (var i = 0; i < this.length; i++) {
						this[i].setAttribute(key, value);
					}
					return this;
				}
				// 값이 undefined 존재하지 않는다면 추출
				return this[0].getAttribute(key);
			}
			else {
				if (value != undefined) {
					this.setAttribute(key, value);
					return this;
				}
				return this.getAttribute(key);
			}
		}
	};

	elements.css = function (key, value) {
		// key가 {} 형태인 경우의 처리
		// value 매개변수 존재하지 않는다, 설정 파트만 존재
		// {"mymsg": "aaa", "title": "연습중.."}
		if (typeof (key) == "object") {
			if (this.length) {
				for (var i = 0; i < this.length; i++) {
					for (var k in key) {
						this[i].style[k] = key[k];
					}
				}
				return this;
			}
			else {
				for (var k in key) {
					this.style[k] = key[k];
				}
				return this;
			}			
		} 
		else {
			if (this.length) {
				// 값이 넘어 왔다면 설정
				if (value != undefined) {
					for (var i = 0; i < this.length; i++) {
						this[i].style[key] = value;
					}
					return this;
				}
				// 값이 undefined 존재하지 않는다면 추출
				return this[0].style[key];
			}
			else {
				if (value != undefined) {
					this.style[key] = value;
					return this;
				}
				return this.style[key];
			}
		}
	};
	
	elements.append = function (childEle) {
		
		if (this.length) {
			for (var i = 0; i < this.length; i++) {
				var cloneNode = childEle.cloneNode();
				cloneNode.innerHTML = childEle.html();
				this[i].appendChild(cloneNode);
			}
			return this;
		}
		else {
			this.appendChild(childEle);
			return this;
		}
	};
	
	elements.on = function (eventType, callback) {
		
		if (this.length) {
			for (var i = 0; i < this.length; i++) {
				this[i].addEventListener(eventType, callback);
			}
			return this;
		}
		else {
			this.addEventListener(eventType, callback);
			return this;
		}
	};
	
	return elements;
}

var $ = mlec;















