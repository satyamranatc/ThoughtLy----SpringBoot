let SignupFormData = document.getElementById("SignupFormData");
let LoginFormData = document.getElementById("LoginFormData");



SignupFormData.addEventListener("submit",async(e)=>{
    e.preventDefault();
    let Data = {
        name:SignupFormData[0].value,
        avatar:SignupFormData[1].value,
        email:SignupFormData[2].value,
        password:SignupFormData[3].value
    }
    console.log(Data);

    let Res = await fetch("http://localhost:8080/api/user/signup",{
        method:"POST",
        body:JSON.stringify(Data),
        headers:{
            "Content-Type":"application/json"
        }
    })
    let ResData = await Res.json();
    console.log(ResData);
    if(ResData.status == "success")
    {
        localStorage.setItem("userData",JSON.stringify(ResData.data));
        window.location.href = "../Thoughts/Thought.html";
    }
    else
    {
        alert(ResData.message);
    }
})


LoginFormData.addEventListener("submit",async(e)=>{
    e.preventDefault();
    let Data = {

        email:SignupFormData[0].value,
        password:SignupFormData[1].value
    }
    console.log(Data);

    let Res = await fetch("http://localhost:8080/api/user/login",{
        method:"POST",
        body:JSON.stringify(Data),
        headers:{
            "Content-Type":"application/json"
        }
    })
    let ResData = await Res.json();
    console.log(ResData);
    if(ResData.status == "success")
    {
        localStorage.setItem("userData",JSON.stringify(ResData.data));
        window.location.href = "../Thoughts/Thought.html";
    }
    else
    {
        alert(ResData.message);
    }
})