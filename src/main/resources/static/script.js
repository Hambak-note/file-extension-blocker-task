$(document).ready(function() {

    $('.custom-extension-buttons').on('click', 'button', function() {

        const button = $(this);
        const extensionName = button.text().slice(0, -2);

        const data = {
            extensionName: extensionName
        }

        fetch('fileExtensions/delete', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => response.json())
            .then(result => {
                if (result.message === "SUCCESS") {
                    button.remove();
                    const displayValueSpan = document.getElementById('displayValue');
                    const spanText = displayValueSpan.textContent.trim();
                    const currentValue = parseInt(spanText.split('/')[0]);

                    const newSpanText = (currentValue - 1) + '/' + spanText.split('/')[1];
                    displayValueSpan.textContent = newSpanText;
                } else {
                    alert('삭제 실패');
                }
            })
            .catch(error => {
                alert("업데이트 실패 : " + error);
            });
    });

    const checkBoxes = document.querySelectorAll('.fixed-extension-checkbox');
    checkBoxes.forEach(checkBox => {
        checkBox.addEventListener('change', function() {
            const isChecked = this.checked; // 체크 여부를 가져옵니다.
            const extensionName = this.nextElementSibling.textContent;

            const checked = isChecked ? 'Y' : 'N';

            const data = {
                checked: checked,
                extensionName: extensionName
            };

            fetch('/fileExtensions/update', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            })
                .then(response => response.json())
                .then(result => {
                    if (result.message === "SUCCESS") {
                    } else {
                        alert("업데이트 실패");
                    }
                })
                .catch(error => {
                    alert("업데이트 실패 : " + error);
                });
        });
    });

    const addButton = document.querySelector('.custom-extension-add-button');
    addButton.addEventListener('click', function() {
        const inputElement = document.querySelector('.custom-extension-input');
        const customExtension = inputElement.value.trim();

        const displayValueSpan = document.getElementById('displayValue');
        const spanText = displayValueSpan.textContent.trim();
        const currentValue = parseInt(spanText.split('/')[0]);

        if (customExtension.length > 20) {
            alert("커스텀 확장자는 최대 20자까지 입력 가능합니다.");
            return;
        }

        if(currentValue >= 200) {
            alert("커스텀 확장자는 최대 200개 까지 저장 가능합니다.");
            return;
        }

        const data = {
            extensionName: customExtension,
            fixedExtension: 'N',
            checked: 'N'
        };

        fetch('/fileExtensions/save', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => response.json())
            .then(result => {
                if (result.message === "SUCCESS") {


                    const newSpanText = (currentValue + 1) + '/' + spanText.split('/')[1];
                    displayValueSpan.textContent = newSpanText;

                    const newButton = document.createElement('button');
                    newButton.textContent = customExtension + ' X';

                    const customExtensionButtons = document.querySelector('.custom-extension-buttons');
                    customExtensionButtons.appendChild(newButton);
                } else {
                    alert("추가 실패");
                }
            })
            .catch(error => {
                alert("추가 실패 : " + error);
            });
    });
});