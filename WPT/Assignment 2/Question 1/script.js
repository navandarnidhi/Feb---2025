// Wait until the page is fully loaded
window.onload = function() {
    const button = document.getElementById('styleBtn');
    const para = document.getElementById('myPara');
  
    button.addEventListener('click', function() {
      para.style.color = "#6a11cb";
      para.style.backgroundColor = "#e0c3fc";
      para.style.fontSize = "24px";
      para.style.fontWeight = "bold";
      para.style.border = "2px solid #6a11cb";
      para.style.padding = "20px";
      para.style.borderRadius = "15px";
      para.style.boxShadow = "0px 8px 16px rgba(106, 17, 203, 0.4)";
      para.style.transition = "all 0.5s ease";
    });
  };
  