document.querySelector("#clic").addEventListener("click",
function myFunction() {
    var x = document.getElementById("myTopnav");
    if (x.className === "topnav") {
        x.className += " responsive";
    } else {
        x.className = "topnav";
    }
});

document.querySelector("#connexion").addEventListener("click",
function yolo(){
  var loginArrierePlan = document.getElementById('id01').style.display='block';
});

document.querySelector(".close").addEventListener("click",
function yolobitch(){
  var loginArrierePlan = document.getElementById('id01').style.display='none';
});

document.querySelector("#boutonAnnuler").addEventListener("click",
function yolobitch(){
  var loginArrierePlan = document.getElementById('id01').style.display='none';
});
