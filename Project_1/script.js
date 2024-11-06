
document.getElementById("reservebutton").addEventListener("click", function () {
  if (document.querySelector("#reserve").style.display === "flex") {
      document.querySelector("#reserve").style.display = "none";
      document.querySelector("#checkreservation").style.display = "none";
  }
  else {
      document.querySelector("#reserve").style.display = "flex";
      document.querySelector("#checkreservation").style.display = "none";
  }
})


document.getElementById("checkreservationbutton").addEventListener("click", function () {
  if (document.querySelector("#checkreservation").style.display === "flex") {
      document.querySelector("#checkreservation").style.display = "none";
      document.querySelector("#reserve").style.display = "none";
  }
  else {
      document.querySelector("#checkreservation").style.display = "flex";
      document.querySelector("#reserve").style.display = "none";
  }

})

const submit=document.querySelector(".submitbtn");

submit.addEventListener("click",function(){
  alert("hii");
})

