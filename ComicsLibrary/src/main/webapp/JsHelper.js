document.addEventListener("DOMContentLoaded", () => {
    const table = document.getElementById("editTable");

    table.addEventListener("dblclick", (e) => {
        if (e.target.tagName === "TD") {
            const td = e.target;
            const originalValue = td.innerText;
            const isbn = td.dataset.id;
            const column = td.dataset.column;

            const input = document.createElement("input");
            input.type = "text";
            input.value = originalValue;
            td.innerHTML = "";
            td.appendChild(input);
            input.focus();

            // Handle blur: Always save on blur
            input.addEventListener("blur", () => {
                const newValue = input.value;
                td.innerHTML = newValue;

                // Send to backend
                fetch("library", {
                    method: "POST",
                    headers: { "Content-type": "application/x-www-form-urlencoded" },
                    body: "action=edit&isbn=" + encodeURIComponent(isbn) + "&column=" + encodeURIComponent(column) + "&value=" + encodeURIComponent(newValue)
                })
                .then(response => response.text())
                .then(result => { console.log("Updated:", result); })
                .catch(error => console.log("Error:", error));
            });

            // Handle Escape: Cancel editing
            input.addEventListener("keydown", (event) => {
                if (event.key === "Escape") {
                    td.innerHTML = originalValue;
                }
            });
            
            fetch("library",{
            	method : "POST",
            	headers: { "Content-type": "application/x-www-form-urlencoded" },
            	body: "action=viewBooks"
            })
        }
    });
});