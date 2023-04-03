
export const appendExceptions = (obj)=>{
    const container = document.querySelector("#container");
    container.innerHTML="";
   
    let div = document.createElement("div");
    let pmessage = document.createElement("p")
    let pdescription = document.createElement("p");
    let ptimestamp = document.createElement("p");

    ptimestamp.innerText=obj.timestamp.substring(0,16);
    pmessage.innerText=obj.message;
    pdescription.innerText=obj.description;

    div.style.width="400px";
    div.style.height="200px";

        div.append(pdescription,pmessage,ptimestamp);
        container.append(div);
}
