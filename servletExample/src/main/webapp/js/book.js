document.addEventListener("DOMContentLoaded", () => {
    const button = document.getElementById("btn");

    button.addEventListener("click", (event) => {
        const title = document.getElementById("title").value.trim();
        const author = document.getElementById("author").value.trim();
        const publisher = document.getElementById("publisher").value.trim();

        if (!title || !author || !publisher) {
            alert("빈칸을 채워주세요 이새끼야");
        } else {
            // 추가 동작을 여기서 수행할 수 있습니다.
            console.log("Form submitted with:", { title, author, publisher });
        }
    });
});