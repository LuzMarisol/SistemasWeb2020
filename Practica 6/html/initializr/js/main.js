var bLogeo = document.getElementById('signin');
//bLogeo.innerHTML = "algo"
bLogeo.addEventListener('click', function() { //acción de escucha
  //alert('hola ' + document.getElementById('email').value);
  const parametros = new URLSearchParams();//Enviar estos parametros de el Login y el password a algo más
  parametros.append('Prtemail', document.getElementById('email').value);
  parametros.append('Prtpassword', document.getElementById('password').value);
  //alert(parametros)
  axios.get('http://127.0.0.1:4567/hello' + parametros, parametros)
       .then(function (response) {
           onsole.log(response)
       })
       .catch(function(error){
          console.log(error)
       })
})