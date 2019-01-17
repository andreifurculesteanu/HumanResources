function confirmDelete(){
    if(!confirm("The employee will be deleted. Do you want to continue?")) return false;
}

function confirmAdd(){
    if(!confirm("Do you want to add a new employee")) return false;
}

function goHome(){
	window.location.href = "http://localhost:8080/HumanResources/ServletApp";
}

function display(){
    document.getElementById("disp").innerHTML = " ";

    //input empno
    var x = document.createElement("input");
    x.setAttribute("type", "text");
    x.setAttribute("id", "empno");
    x.setAttribute("placeholder", "Number");
    disp.appendChild(x);

    //break
    disp.appendChild(document.createElement("br"));
    disp.appendChild(document.createElement("br"));

    //input Salary (min)
    var y = document.createElement("input");
    y.setAttribute("type", "text");
    y.setAttribute("id", "salmin");
    y.setAttribute("placeholder", "Salary (min)");
    disp.appendChild(y);

    //break
    disp.appendChild(document.createElement("br"));
    disp.appendChild(document.createElement("br"));

    //input Salary (max)
    var z = document.createElement("input");
    z.setAttribute("type", "text");
    z.setAttribute("id", "salmax");
    z.setAttribute("placeholder", "Salary (max)");
    disp.appendChild(z);

    //break
    disp.appendChild(document.createElement("br"));
    disp.appendChild(document.createElement("br"));

    //input Hiredate (min)
    var h = document.createElement("input");
    h.setAttribute("type", "text");
    h.setAttribute("id", "hiremin");
    h.setAttribute("placeholder", "Hiredate (min)");
    disp.appendChild(h);

    //break
    disp.appendChild(document.createElement("br"));
    disp.appendChild(document.createElement("br"));

    //input Hiredate (max)
    var k = document.createElement("input");
    k.setAttribute("type", "text");
    k.setAttribute("id", "hiremax");
    k.setAttribute("placeholder", "Hiredate (max)");
    disp.appendChild(k);
    
    //break
    disp.appendChild(document.createElement("br"));
    disp.appendChild(document.createElement("br"));

    var b = document.createElement("input");
    b.setAttribute("type", "button");
    b.setAttribute("id", "but");
    b.setAttribute("value", "Search");
    b.setAttribute("onClick", "search();");
    disp.appendChild(b);
}