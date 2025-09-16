var colors=["white","red","pink","purple","blue","yellow"];
var len=colors.length-1;
let btn=document.getElementById('btn');
let color=document.getElementById('color');

btn.addEventListener('click',()=>{
    let index=genrandom();
    document.body.style.background=colors[index];
    color.innerHTML=colors[index];
})
function genrandom(){
    return Math.round(Math.random()*len);
}