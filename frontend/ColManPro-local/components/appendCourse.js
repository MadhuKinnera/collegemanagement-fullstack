
export const appendCourses = (data)=>{
    const container = document.querySelector("#container");
    container.innerHTML="";
    data.forEach(ele => {
        let div = document.createElement("div");
        let pid = document.createElement("p");
        let pname = document.createElement("p")
        let pduration = document.createElement("p");
        let pprice = document.createElement("p");
        
        
        pid.innerText=ele.courseId;
        pname.innerText=ele.courseName.toUpperCase();
        pduration.innerText=ele.price;
        pprice.innerText=ele.duration;
       

        div.append(pid,pname,pduration,pprice);
        container.append(div);
    });
}

