/**
 * 
 */
document.addEventListener("DOMContentLoaded",()=>{
	const table = document.getElementById('editTable');
	
	table.addEventListener("dblclick",(e)=>{
		if(e.target.tagName === "TD"){
			const td = e.target;
			const originalValue = td.innerText;
			const sid = td.dataset.sid;
			const column = td.dataset.column;
			
			const input = document.createElement("input");
			
			input.type ="text";
			input.value = td.innerHTML;
			input.focus();
			td.innerHTML = "";
			td.appendChild(input);
			
			input.addEventListener("blur",()=>{
				const newValue = input.value;
				td.innerHTML = newValue;
				
				fetch("HandlingUpdateServlet",{
					method:"POST",
					headers:{"Content-type":"application/x-xxx-form-urlencoded"},
					body:""
				})
			})
		}
	})
})