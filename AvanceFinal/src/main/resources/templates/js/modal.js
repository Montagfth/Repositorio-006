document.addEventListener('DOMContentLoaded', function(){

    const modal = document.getElementById('modal1');

    const modalBody = modal.querySelector('.modal-body');

modal.addEventListener('show.bs.modal', function(event){

    const button = event.relatedTarget;

    const curso = button.getAttribute('data-curso');

    switch(curso){

        case 'inicio':

            modalBody.innerHTML= `

            <h5>Información</h5>

            <p> La PIZZA es una excelente comida para muchos momentos, por eso hemos desarrollado varias maneras para vivir la experiencia de Pizza Factory</p>

            `;

            break

            case 'eventos':

                modalBody.innerHTML= `

                <h5>Cotiza tu evento</h5>

                <p> Ya decidiste y deseas cotizar tu evento, vamos!</p>

                `;

                break

    }

    });

});