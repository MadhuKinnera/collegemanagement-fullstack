
 export const appendStudents = (data)=>{
    const container = document.querySelector("#container");
    container.innerHTML="";
    data.forEach(ele => {
        let div = document.createElement("div");
        let pid = document.createElement("p");
        let pname = document.createElement("p")
        let pemail = document.createElement("p");
        let paddress = document.createElement("p");
        let pphone = document.createElement("p");
        
        pid.innerText=ele.studentId;
        pname.innerText=ele.name.toUpperCase();
        paddress.innerText=ele.address;
        pemail.innerText=ele.email;
        pphone.innerText=ele.phoneNumber;

        div.append(pid,pname,pemail,paddress,pphone);
        container.append(div);
        
        
    });
}

