/**
 * 
 */
function validar(){
	
	let nome =frmContacto.nome.value
	let fone =frmContacto.fone.value
	if(nome===""){
		alert('Preecha o nome')
		frmContacto.nome.focus()
		return false
	}else if(fone===""){
		alert('Preecha o fone')
		frmContacto.fone.focus()
		return false
	
	}else{
		document.forms["frmContacto"].submit()
	}
	echo(nome)
	echo(fone)
	}