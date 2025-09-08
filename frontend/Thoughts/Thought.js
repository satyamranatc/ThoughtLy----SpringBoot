document.addEventListener("DOMContentLoaded", (event) => {
    
    let userData = JSON.parse(localStorage.getItem("userData"));
   
    if(userData == null)
   {
    window.location.href = "../Profile/Profile.html";
   }
});