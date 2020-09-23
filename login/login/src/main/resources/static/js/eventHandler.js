/**
 * 이벤트 핸들러 메소드 클래스
 * @author wookim
 * @since 2020.09.18
 */

 class EventHandler{
    EventHandler(){}

    signup(){
        let modal = document.getElementById("myModal");
        let btn = document.getElementById("singup-btn");
        let span = document.getElementsByClassName("close")[0];

        btn.onclick = function() {
          modal.style.display = "block";
        }
        span.onclick = function() {
          modal.style.display = "none";
        }
        window.onclick = function(event) {
          if (event.target == modal) {
            modal.style.display = "none";
          }
        }
    }

    // 최종 회원가입 신청
    async finalSignRequest(){
        let data = {};
        data.userId = document.getElementById('user-id-text').value;
        data.password = document.getElementById('user-pw-text').value;
        data.email = document.getElementById('user-email-text').value;
        fetch("/sign", {
            method: 'POST', // or 'PUT'
            body: JSON.stringify(data), // data can be `string` or {object}!
            headers:{
              'Content-Type': 'application/json'
            }
        })
    }

    // 회원 가입 신청 취소
    CanlseSign(){

    }

    // 로그인 화면 출력
    openLoginModal(){
        let modal = document.getElementById("login-Modal");
        let btn = document.getElementById("login-btn");
        let span = document.getElementsByClassName("close")[0];

        btn.onclick = function() {
          modal.style.display = "block";
        }
        span.onclick = function() {
          modal.style.display = "none";
        }
        window.onclick = function(event) {
          if (event.target == modal) {
            modal.style.display = "none";
          }
        }
    }
    
    login(){
        debugger
        document.getElementById('login-btn').style.visibility = 'hidden';
        document.getElementById('logout-btn').style.visibility = 'visible';

        let data = {}
        data.userId = document.getElementById("login-user-id-text").value;
        data.password = document.getElementById("login-user-pw-text").value;

        fetch("/login", {
            method: 'POST', // or 'PUT'
            body: JSON.stringify(data), // data can be `string` or {object}!
            headers:{
              'Content-Type': 'application/json'
            },
        }).then(res => res.json())
            .then(token => {
                localStorage.setItem("jwt",token.accessToken)
                alert("로그인 되었습니다");
            });
    }
    
    logout(){
        debugger
        document.getElementById('login-btn').style.visibility = 'visible';
        document.getElementById('logout-btn').style.visibility = 'hidden';
    }
 }