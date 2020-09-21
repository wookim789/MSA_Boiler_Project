/** 로그인 컨트롤 클래스
 * @author wookim
 * @since 2020.09.18
 * 
 * 이벤트 바인딩 담당
 */
document.addEventListener('DOMContentLoaded', dom => { // document.ready 역할 대체
    let eventHandler = new EventHandler();

    // 회원가입 버튼 클릭 이벤트 바인딩
    let signUpBtn = document.getElementById('singup-btn');
    signUpBtn.addEventListener('click', b =>{
        eventHandler.signup();
    })

    // 최종 회원가입 버튼 클릭
    let finalSignUpBtn = document.getElementById('singup-to-server-btn');
    finalSignUpBtn.addEventListener('click', b =>{
        eventHandler.finalSignRequest();
    })

    // 취소 버튼 클릭
    let finalSigncCanlseBtn = document.getElementById('cancle-sign-btn');
    finalSigncCanlseBtn.addEventListener('click', b =>{
        eventHandler.CanlseSign();
    })

    // 로그인 버튼 클릭 이벤트 바인딩
    let loginBtn = document.getElementById('login-btn');
    loginBtn.addEventListener('click', async b => {
        eventHandler.login();
    })
    // 로그아웃 버튼 클릭 이벤트 바인딩
    let logoutBtn = document.getElementById('logout-btn');
    logoutBtn.addEventListener('click', b => {
        eventHandler.logout();
    })
})
