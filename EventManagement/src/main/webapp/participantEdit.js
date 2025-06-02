/**
 * 
 */

document.addEventListener("DOMContentLoaded",()=>{
	const table = document.getElementById("editTable");
	
	table.addEventListener("dblclick",(e)=>{
		if(e.target.tagName === "TD"){
			const td = e.target;
			const originalValue = td.innerText;
			const pid =  td.dataset.pid;
			const column = td.dataset.column;
			
			const input = document.createElement("input");
			input.type = "text";
			input.value = originalValue;
			td.innerHTML = "";
			td.appendChild(input);
			input.focus();
			
			input.addEventListener("blur",()=>{
				
				const newValue = input.value;
				td.innerHTML = newValue;
				
				fetch("participant",{
					method : "POST",
					headers : {"Content-type":"application/x-www-form-urlencoded"},
					body : "action=editParticipant&pid="+encodeURIComponent(pid)+"&column="+encodeURIComponent(column)+"&value="+encodeURIComponent(newValue)
				})
				.then(response => response.text())
				.then(result => {console.log(result)})
				.catch(error =>{console.log(error)})
			
			})
			input.addEventListener("keydown",(event)=>{
				if(event.key === "Escape"){
					td.innerHTML = originalValue;
				}
			})
		}
	})
});