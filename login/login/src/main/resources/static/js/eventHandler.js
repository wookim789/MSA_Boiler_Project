/**
 * 이벤트 핸들러 메소드 클래스
 * @author wookim
 * @since 2020.09.18
 */

 class EventHandler{
    EventHandler(){}
    async login(){
        let response = await fetch('/user');
        let json = await response.json()
        document.querySelectorAll('.unauthenticated')[0].style.visibility = 'hidden';
        document.querySelectorAll('.authenticated')[0].style.display = 'block';
        document.getElementById('user').innerHTML = json.name
    }
    
    async logout(){
        console.log('logout');
    }
 }