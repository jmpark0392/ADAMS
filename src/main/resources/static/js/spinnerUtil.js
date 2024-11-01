
let spinnerModal;
let spinner;

function showSpinner() {
    if (!spinnerModal) {
        const modalHtml = `
            <div class="modal fade" id="spinnerModal" tabindex="-1" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content" style="background: transparent; border: none;">
                        <div class="modal-body text-center">
                            <div id="spinnerContainer"></div>
                        </div>
                    </div>
                </div>
            </div>
        `;
        document.body.insertAdjacentHTML('beforeend', modalHtml);
        spinnerModal = new bootstrap.Modal(document.getElementById("spinnerModal"), {
            backdrop: 'static',
            keyboard: false
        });
    }

    const spinnerContainer = document.getElementById('spinnerContainer');
    spinner = new Spinner().spin(spinnerContainer);
    spinnerModal.show(); // Show the modal
}

function hideSpinner() {
    const spinnerContainer = document.getElementById('spinnerContainer');
    return new Promise((resolve) => {
        if (spinnerModal) {
            let spinnerModalElement = document.getElementById('spinnerModal');
            spinnerModalElement.addEventListener('hidden.bs.modal', function handler() {
                spinnerModalElement.removeEventListener('hidden.bs.modal', handler);
                spinnerModalElement.parentNode.removeChild(spinnerModalElement);
                spinnerModal = null;
                spinner = null;
                resolve();
            });

            if (spinner) {
                spinner.stop();
            }

            $(spinnerContainer).fadeOut(200, function() {
                spinnerModal.hide(); // Hide the modal
            });
        } else {
            resolve();
        }
    });
}