package com.rjqdf.ejercicios.ej0;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ejercicio0 {

	public static void main(String[] args) throws Exception {

//		apartado1();
		apartado2();
		
	}
	
	public static void apartado1() {
		
		String[] nombres = {"Lucía", "María", "Martina", "Paula", "Sofía", "Daniela", "Alba", "Julia", "Carla", "Sara", "Valeria", "Noa", "Emma", "Claudia", "Carmen", "Valentina", "Ana", "Marta", "Irene", "Adriana", "Laura", "Elena", "Alejandra", "Vega", "Alma", "Laia", "Lola", "Vera", "Olivia", "Inés", "Aitana", "Jimena", "Candela", "Ariadna", "Carlota", "Ainhoa", "Nora", "Triana", "Marina", "Chloe", "Elsa", "Alicia", "Clara", "Blanca", "Leire", "Mía", "Lara", "Rocío", "Ainara", "Nerea", "Hugo", "Daniel", "Pablo", "Martín", "Alejandro", "Adrián", "Álvaro", "David", "Lucas", "Mateo", "Mario", "Manuel", "Antonio", "Diego", "Leo", "Javier", "Marcos", "Izan", "Alex", "Sergio", "Enzo", "Carlos", "Marc", "Jorge", "Miguel", "Gonzalo", "Juan", "Ángel", "Oliver", "Iker", "Dylan", "Bruno", "Eric", "Marco", "Iván", "Nicolás", "José", "Héctor", "Darío", "Samuel", "Víctor", "Rubén", "Gabriel", "Adam", "Aaron", "Thiago", "Jesús", "Aitor", "Alberto", "Guillermo"};
		String[] apellidos = {"García", "González", "Rodríguez", "Fernández", "López", "Martínez", "Sánchez", "Pérez", "Gómez", "Martín", "Jiménez", "Ruíz", "Hernández", "Díaz", "Moreno", "Muñoz", "Álvarez", "Romero", "Alonso", "Gutiérrez", "Navarro", "Torres", "Domínguez", "Vázquez", "Ramos", "Gil", "Ramírez", "Serrano", "Blanco", "Molina", "Morales", "Suárez", "Ortega", "Delgado", "Castro", "Ortiz", "Rubio", "Marín", "Sanz", "Núñez", "Iglesias", "Medina", "Garrido", "Cortes", "Castillo", "Santos", "Lozano", "Guerrero", "Cano", "Prieto", "Méndez", "Cruz", "Calvo", "Gallego", "Vidal", "León", "Márquez", "Herrera", "Peña", "Flores", "Cabrera", "Campos", "Vega", "Fuentes", "Carrasco", "Díez", "Caballero", "Reyes", "Nieto", "Aguilar", "Pascual", "Santana", "Herrero", "Lorenzo", "Montero", "Hidalgo", "Ibáñez", "Ferrer", "Durán", "Santiago", "Benítez", "Mora", "Vicente", "Vargas", "Arias", "Carmona", "Crespo", "Román", "Pastor", "Soto", "Sáez", "Velasco", "Moya", "Soler", "Parra", "Esteban", "Bravo", "Gallardo", "Rojas", "Casado"};
		
		for (int i = 0; i < 100; i++) {
			
			// Math.random() -> valor aleatorio entre 0 (incluido) y 1 (excluido)
			String nombreAleatorio = nombres[(int) (Math.random() * nombres.length)];
			String apellido1Aleatorio = apellidos[(int) (Math.random() * apellidos.length)];
			String apellido2Aleatorio = apellidos[(int) (Math.random() * apellidos.length)];
			
			System.out.println((i+1) + ". " + nombreAleatorio + " " + apellido1Aleatorio + " " + apellido2Aleatorio);
		}
		
	}
	
	public static void apartado2() throws Exception {
		
		
		for (int i = 0; i < 100; i++) {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			long milisegundosIniciales = sdf.parse("01/01/1980").getTime();
			long milisegundosFinales = sdf.parse("31/12/2000").getTime();
			
			long rangoFechas = milisegundosFinales - milisegundosIniciales;
			
			long numeroAleatorio = (long) (Math.random() * rangoFechas + milisegundosIniciales);
			
			
			Date fechaAleatoria = new Date(numeroAleatorio);
			
			System.out.println(fechaAleatoria);
			
		}
		
	}

}
