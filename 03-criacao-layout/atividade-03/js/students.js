
const btn = document.querySelector("#send");

btn.addEventListener("click", function(e) {

    const note1 = document.querySelector("#note1");
    const note2 = document.querySelector("#note2");
    const media = (note1 + note2)/2;

    const value1 = note1.value;
    const value2 = note2.value;

    media = document.getElementById("#media").style.color = green;
})
    

function validateStudents(){

    if(media > 6){
        document.getElementById("media").style.color = "green";
    }
}