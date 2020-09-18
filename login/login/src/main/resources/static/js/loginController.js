/** 로그인 컨트롤 클래스
 * @author wookim
 * @since 2020.09.18
 * 
 * 이벤트 바인딩 담당
 */
document.addEventListener('DOMContentLoaded', dom => { // document.ready 역할 대체

    // 로그아웃 버튼 클릭 이벤트 바인딩
    let loginBtn = document.getElementById('login-btn')
    loginBtn.addEventListener('click', async login => {
        let response = await fetch('/user');
        let json = await response.json()
        document.querySelectorAll('.unauthenticated')[0].style.visibility = 'hidden';
        document.querySelectorAll('.authenticated')[0].style.display = 'block';
        document.getElementById('user').innerHTML = json.name
    })
    // 로그아웃 버튼 클릭 이벤트 바인딩
    let logoutBtn = document.getElementById('logout-btn')
    logoutBtn.addEventListener('click', logout => {
        alert('logout.')
    })
})
