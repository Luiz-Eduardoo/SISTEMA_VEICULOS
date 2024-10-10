import java.time.LocalDate; // import para conseguir usar o LocalDate
// classe com os atributos em comum com outras classes
	class CaracteristicasComuns {
		// Atributos comuns
		private String modelo;
		private int anofabricacao;
		private String montadora;
		private String cor;
		private int km;
			// metodo construtor para montar as caracteristicas
			public CaracteristicasComuns (String modelo, int anofabricacao, String montadora, String cor, int km) {
				setModelo(modelo);
		        setAnofabricacao(anofabricacao);
		        setMontadora(montadora);
		        setCor(cor);
		        setKm(km);
			}
			// método get para acessar o atributo
			public String getModelo() {
				return modelo;
			}
			// método set para modificar o valor do atributo
			public void setModelo(String modelo) {
				if (modelo == null || modelo.trim().isEmpty()) { // trim para tirar os espaços desnecessários e isEmpty para avisar se estiver vazio
		            throw new IllegalArgumentException("Informe o modelo do veículo");
			}
				this.modelo = modelo;
			}

			public int getAnofabricacao() {
				return anofabricacao;
			}

			public void setAnofabricacao(int anofabricacao) {
		        int anoMinimo = 1900; // int para fazer a validação do ano de fabricação
		        int anoMaximo = LocalDate.now().getYear() + 1; // limite do ano de fabricação (ano atual + 1)

		        if (anofabricacao < anoMinimo || anofabricacao > anoMaximo) { // se não estiver dentro do limite vai dar erro
		            throw new IllegalArgumentException("O ano de fabricação do veículo deve ser entre " + anoMinimo + " e " + anoMaximo);
		        }
		        this.anofabricacao = anofabricacao;
		    }

			public String getMontadora() {
				return montadora;
			}

			public void setMontadora(String montadora) {
				if (montadora == null || montadora.trim().isEmpty()) { 
		            throw new IllegalArgumentException("Informe a montadora do veículo");
		        }
		        this.montadora = montadora;
		    }

			public String getCor() {
				return cor;
			}

			 public void setCor(String cor) {
			        if (cor == null || cor.trim().isEmpty()) { 
			            throw new IllegalArgumentException("Informe a cor do veiculo");
			        }
			        this.cor = cor;
			 }

			public int getKm() {
				return km;
			}

			public void setKm(int km) {
		        if (km < 0) { // se for abaixo de 0 vai dar erro
		            throw new IllegalArgumentException("Informe corretamente a kilometragem do veiculo");
		        }
		        this.km = km;
		    }
			// metodo para retornar as informações formatadas
			public String descricao() {
				return "\n Modelo: " + modelo + " \n Ano de Fabricação: " + anofabricacao + " \n Montadora: " + montadora + " \n Cor: " + cor + " \n Kilometragem: " + km;
			}
			public String insert() {
			    return "INSERT INTO CaracteristicasComuns (modelo, anofabricacao, montadora, cor, km) VALUES ('" + getModelo() + "', " + getAnofabricacao() + ", '" + getMontadora() + "', '" + getCor() + "', " + getKm() + ");";
			}
	}
	// classe Automóvel com os atributos específicos necessários
	class Automóvel extends CaracteristicasComuns {// extends para fazer a Herança dos atributos em comum colocados na classe CaracteristicasComuns
		// Atributos Específicos
		private int qntdPassageiro;
		private String freio;
		private String airbag;
			// metodo construtor para montar as caracteristicas
			public Automóvel(String modelo, int anofabricacao, String montadora, String cor, int km, int qntdPassageiro, String freio, String airbag) {
				super(modelo, anofabricacao, montadora, cor, km); // pega as caracteristicas do CaracteristicasComuns
				 setQntdPassageiro(qntdPassageiro); // set para fazer o sistema de validação
			     setFreio(freio);
			     setAirbag(airbag);
			}
			// método get para acessar o atributo
			public int getQntdPassageiro() {
				return qntdPassageiro;
			}
			// método set para modificar o valor do atributo
			public void setQntdPassageiro(int qntdPassageiro) {
		        if (qntdPassageiro <= 0) { // se for igual ou abaixo de 0 vai dar erro
		            throw new IllegalArgumentException("A quantidade de passageiros do automóvel precisa ser maior que 0");
		        }
		        this.qntdPassageiro = qntdPassageiro;
		    }

			public String getFreio() {
				return freio;
			}

			public void setFreio(String freio) {
				if (freio == null || freio.trim().isEmpty()) { // trim para tirar os espaços desnecessários e isEmpty para avisar se estiver vazio
		            throw new IllegalArgumentException("Informe o tipo de freio do automóvel");
		        }
		        this.freio = freio;
		    }

			public String getAirbag() {
				return airbag;
			}

			public void setAirbag(String airbag) {
				if (airbag == null || airbag.trim().isEmpty()) { 
		            throw new IllegalArgumentException("Informe o airbag do automóvel");
		        }
		        this.airbag = airbag;
		    }
			
			// metodo para retornar as informações formatadas
			public String descricao() {
				// "super" para pegar as informaçoes formatadas da classe CaracteristicasComuns e adicionar as informações especificas dessa classe
				return super.descricao() + " \n Quantidade de Passageiros: " + qntdPassageiro + "\n Tipo de freio: " + freio + "\n Airbag: " + airbag;
			}
			public String insert() {
			    return "INSERT INTO Automovel (modelo, anofabricacao, montadora, cor, km, qntdPassageiro, freio, airbag) VALUES ('" + getModelo() + "', " + getAnofabricacao() + ", '" + getMontadora() + "', '" + getCor() + "', " + getKm() + ", " + getQntdPassageiro() + ", '" + getFreio() + "', '" + getAirbag() + "');";
			}
	}
	// classe Motocicleta com os atributos específicos necessários
	class Motocicleta extends CaracteristicasComuns { // extends para fazer a Herança dos atributos gerais colocados na  classe CaracteristicasComuns
		// Atributos específicos
		private int cilindrada;
		private double torque;
		// metodo construtor para montar as caracteristicas
		public Motocicleta(String modelo, int anofabricacao, String montadora, String cor, int km, int cilindrada, double torque) {
			super(modelo, anofabricacao, montadora, cor, km); // pega as caracteristicas do CaracteristicasComuns
			setCilindrada(cilindrada); // set para fazer o sistema de validação
	        setTorque(torque);
		}
		// método get para acessar o atributo
		public int getCilindrada() {
			return cilindrada;
		}
		// método set para modificar o valor do atributo
		public void setCilindrada(int cilindrada) {
	        if (cilindrada <= 0) { // se for igual ou abaixo de 0 vai dar erro
	            throw new IllegalArgumentException("Informe a quantidade de cilindradas da moto");
	        }
	        this.cilindrada = cilindrada;
	    }

		public double getTorque() {
			return torque;
		}

		public void setTorque(double torque) {
	        if (torque < 0) { // se for abaixo de 0 vai dar erro
	            throw new IllegalArgumentException("Informe o torque da moto");
	        }
	        this.torque = torque;
	    }
		// metodo para retornar as informações formatadas
		public String descricao() {
			// "super" para pegar as informaçoes formatadas da classe CaracteristicasComuns e adicionar as informações especificas dessa classe
			return super.descricao() + " \n Cilindradas: " + cilindrada + " \n Torque: " + torque + " kgfm";
		}
		public String insert() {
		    return "INSERT INTO Motocicleta (modelo, anofabricacao, montadora, cor, km, cilindrada, torque) VALUES ('" + getModelo() + "', " + getAnofabricacao() + ", '" + getMontadora() + "', '" + getCor() + "', " + getKm() + ", " + getCilindrada() + ", " + getTorque() + ");";
		}

	}
	// classe Caminhões com os atributos específicos necessários
	class Caminhao extends CaracteristicasComuns { // extends para fazer a Herança dos atributos gerais colocados na  classe CaracteristicasComuns
		// Atributos específicos
		private int qntdEixos;
		private double pesoBruto;
		// metodo construtor para montar as caracteristicas
		public Caminhao(String modelo, int anofabricacao, String montadora, String cor, int km, int qntdEixos, double pesoBruto) {
			super(modelo, anofabricacao, montadora, cor, km); // pega as caracteristicas do CaracteristicasComuns
			setQntdEixos(qntdEixos); // set para fazer o sistema de validação
	        setPesoBruto(pesoBruto);
		}
		// método get para acessar o atributo
		public int getQntdEixos() {
			return qntdEixos;
		}
		// método set para modificar o valor do atributo
		public void setQntdEixos(int qntdEixos) {
	        if (qntdEixos <= 0) { // se for igual ou abaixo de zero vai dar erro
	            throw new IllegalArgumentException("Informe a quantidade de eixos do caminhão");
	        }
	        this.qntdEixos = qntdEixos;
	    }
		
		public double getPesoBruto() {
			return pesoBruto;
		}
		public void setPesoBruto(double pesoBruto) {
	        if (pesoBruto <= 0) { // se for igual ou abaixo de zero vai dar erro
	            throw new IllegalArgumentException("Informe o peso bruto do caminhão");
	        }
	        this.pesoBruto = pesoBruto;
	    }
		// metodo para retornar as informações formatadas
		public String descricao() {
			// "super" para pegar as informaçoes formatadas da classe CaracteristicasComuns e adicionar as informações especificas dessa classe
			return super.descricao() + " \n Quantidade de Eixos: " + qntdEixos + " \n Peso bruto: " + pesoBruto + " toneladas";
		}
		public String insert() {
		    return "INSERT INTO Caminhao (modelo, anofabricacao, montadora, cor, km, qntdEixos, pesoBruto) VALUES ('" + getModelo() + "', " + getAnofabricacao() + ", '" + getMontadora() + "', '" + getCor() + "', " + getKm() + ", " + getQntdEixos() + ", " + getPesoBruto() + ");";
		}

	}
	// classe Bicicleta com os atributos específicos necessários
	class Bicicleta {
		// Atributos específicos
		private String modelo;
		private int anofabricacao;
		private String marca;
		private String cor;
		private String material;
		private int qntdMarcha;
		private String amortecedor;
		// metodo construtor para montar as caracteristicas
		public Bicicleta(String modelo, int anofabricacao, String marca, String cor, String material, int qntdMarcha, String amortecedor) {
			setModelo(modelo); // set para fazer o sistema de validação
	        setAnofabricacao(anofabricacao);
	        setMarca(marca);
	        setCor(cor);
	        setMaterial(material);
	        setQntdMarcha(qntdMarcha);
	        setAmortecedor(amortecedor);
		}
		// método get para acessar o atributo
		public String getModelo() {
			return modelo;
		}
		// método set para modificar o valor do atributo
		public void setModelo(String modelo) {
	        if (modelo == null || modelo.trim().isEmpty()) { // trim para tirar os espaços desnecessários e isEmpty para avisar se estiver vazio
	            throw new IllegalArgumentException("Informe o modelo da bicicleta");
	        }
	        this.modelo = modelo;
	    }

		public int getAnofabricacao() {
			return anofabricacao;
		}
		
		public void setAnofabricacao(int anofabricacao) {
	        int anoMinimo = 1900; // int para estabelecer o limite minimo do ano de fabricação
	        int anoMaximo = LocalDate.now().getYear() + 1; // limite maximo do ano de fabricação (ano atual + 1)

	        if (anofabricacao < anoMinimo || anofabricacao > anoMaximo) { // se estiver fora do limite vai dar erro
	            throw new IllegalArgumentException("O ano de fabricação da bicicleta deve ser entre " + anoMinimo + " e " + anoMaximo);
	        }
	        this.anofabricacao = anofabricacao;
	    }
		
		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
	        if (marca == null || marca.trim().isEmpty()) { 
	            throw new IllegalArgumentException("Informe a marca da bicicleta");
	        }
	        this.marca = marca;
	    }

		public String getCor() {
			return cor;
		}

		public void setCor(String cor) {
	        if (cor == null || cor.trim().isEmpty()) { 
	            throw new IllegalArgumentException("Informe a cor da bicicleta");
	        }
	        this.cor = cor;
	    }

		public String getMaterial() {
			return material;
		}

		 public void setMaterial(String material) {
		        if (material == null || material.trim().isEmpty()) { 
		            throw new IllegalArgumentException("Informe o material da bicicleta");
		        }
		        this.material = material;
		    }

		public int getQntdMarcha() {
			return qntdMarcha;
		}

		public void setQntdMarcha(int qntdMarcha) {
	        if (qntdMarcha <= 0) { // se for igual ou abaixo de 0 vai dar erro
	            throw new IllegalArgumentException("Informe a quantidade de marchas da bicicleta");
	        }
	        this.qntdMarcha = qntdMarcha;
	    }

		public String getAmortecedor() {
			return amortecedor;
		}

		public void setAmortecedor(String amortecedor) {
	        if (amortecedor == null || amortecedor.trim().isEmpty()) { 
	            throw new IllegalArgumentException("Informe o amortecedor da bicicleta");
	        }
	        this.amortecedor = amortecedor;
	    }
		
		// metodo para retornar as informações formatadas
		public String descricao() {
			return "\n Modelo da Bicicleta: " + modelo + " \n Ano de Fabricação: " + anofabricacao + " \n Marca: " + marca + " \n Cor: " + cor + " \n Material: " + material + " \n Quantidade de Marchas: " + qntdMarcha + " \n Amortecedor: " + amortecedor;
		}
		public String insert() {
		    return "INSERT INTO Bicicleta (modelo, anofabricacao, marca, cor, material, qntdMarcha, amortecedor) VALUES ('" + getModelo() + "', " + getAnofabricacao() + ", '" + getMarca() + "', '" + getCor() + "', '" + getMaterial() + "', " + getQntdMarcha() + ", '" + getAmortecedor() + "');";
		}

	}
	// classe Skate com os atributos específicos necessários
	class Skate {
		// Atributos específicos
		private String modelo;
		private int anofabricacao;
		private String marca;
		private String cor;
		private String tipoRoda;
		// metodo construtor para montar as caracteristicas
		public Skate(String modelo, int anofabricacao, String marca, String cor, String tipoRoda) {
			setModelo(modelo); // set para fazer o sistema de validação
			setAnofabricacao(anofabricacao);
	        setMarca(marca);
	        setCor(cor);
	        setTipoRoda(tipoRoda);
		}
		// método get para acessar o atributo
		public String getModelo() {
			return modelo;
		}
		// método set para modificar o valor do atributo
		public void setModelo(String modelo) {
	        if (modelo == null || modelo.trim().isEmpty()) { // trim para tirar os espaços desnecessários e isEmpty para avisar se estiver vazio
	            throw new IllegalArgumentException("Informe o modelo do skate");
	        }
	        this.modelo = modelo;
	    }

		public int getAnofabricacao() {
			return anofabricacao;
		}
		
		public void setAnofabricacao(int anofabricacao) {
	        int anoMinimo = 1900; // int para estabelecer o limite minimo do ano de fabricação
	        int anoMaximo = LocalDate.now().getYear() + 1; // limite maximo do ano de fabricação (ano atual + 1)

	        if (anofabricacao < anoMinimo || anofabricacao > anoMaximo) {
	            throw new IllegalArgumentException("O ano de fabricação do skate deve ser entre " + anoMinimo + " e " + anoMaximo);
	        }
	        this.anofabricacao = anofabricacao;
	    }
		
		public String getMarca() {
			return marca;
		}

		 public void setMarca(String marca) {
		        if (marca == null || marca.trim().isEmpty()) {
		            throw new IllegalArgumentException("Informe a marca do skate");
		        }
		        this.marca = marca;
		 }

		public String getCor() {
			return cor;
		}

		public void setCor(String cor) {
	        if (cor == null || cor.trim().isEmpty()) {
	            throw new IllegalArgumentException("Informe a cor do skate");
	        }
	        this.cor = cor;
	    }

		public String getTipoRoda() {
			return tipoRoda;
		}

		 public void setTipoRoda(String tipoRoda) {
		        if (tipoRoda == null || tipoRoda.trim().isEmpty()) {
		            throw new IllegalArgumentException("Informe o tipo de roda do skate");
		        }
		        this.tipoRoda = tipoRoda;
		 }
		 
		// metodo para retornar as informações formatadas
		public String descricao() {
			return " \n Modelo do Skate: " + modelo + " \nAno de fabricação: " + anofabricacao + " \n Marca: " + marca + " \n Cor: " + cor + " \n Tipo de Roda: " + tipoRoda;
		}
		public String insert() {
		    return "INSERT INTO Skate (modelo, anofabricacao, marca, cor, tipoRoda) VALUES ('" + getModelo() + "', " + getAnofabricacao() + ", '" + getMarca() + "', '" + getCor() + "', '" + getTipoRoda() + "');";
		}

	}
public class Herança_3 {
	public static void main(String[] args) {
		// criando novo objeto dando valor aos atributos
		 try {
	            Automóvel a1 = new Automóvel("Corolla", 2024, "Toyota", "Preto", 12000, 5, "Freio a Disco", "Frontal");
	            Automóvel a2 = new Automóvel("RS6", 2023, "Audi", "Branca", 5000, 5, "Freio a Disco ventilados", "Frontais, laterais e cortina");
	            Automóvel a3 = new Automóvel("AMG G63", 2024, "Mercedes-Benz", "Cinza", 0, 5, "Freio a Disco ventilados, com ABS", "Frontais, laterais e cortina");
	            Motocicleta m1 = new Motocicleta("XRE 300", 2020, "Honda", "Branca", 13000, 291, 2.75);
	            Motocicleta m2 = new Motocicleta("Tiger 1200", 2023, "Triumph", "Azul", 0, 1160, 13.24);
	            Motocicleta m3 = new Motocicleta("S1000RR", 2023, "BMW", "Preta", 1000, 999, 11.52);
	            Caminhao c1 = new Caminhao("Scania 113", 1996, "Scania", "Vermelho", 112000, 3, 19);
	            Caminhao c2 = new Caminhao("Scania R 450", 2023, "Scania", "Preto", 43000, 3, 18);
	            Caminhao c3 = new Caminhao("Volvo FH 540", 2023, "Volvo", "Branco", 56000, 3, 18);
	            Bicicleta b1 = new Bicicleta("Caloi 10", 2022, "Caloi", "Azul", "Aço", 18, "Dianteiro");
	            Bicicleta b2 = new Bicicleta("Monark Elite", 2023, "Monark", "Vermelha", "Alumínio", 18, "Sem amortecedor");
	            Bicicleta b3 = new Bicicleta("Caloi Fusion", 2021, "Caloi", "Preto", "Alumínio", 21, "Dianteiro");
	            Skate s1 = new Skate("Element Skateboard", 2020, "Element", "Preto", "Uretano 54mm, 99A");
	            Skate s2 = new Skate("Cruizer Longboard", 2019, "Cruizer", "Madeira natural", "Uretano 70mm, 78A");
	            Skate s3 = new Skate("Fish Skateboard", 2020, "Fish", "Azul", "Uretano 60mm, 83A");

	            // Imprimindo as informações formatadas de cada objeto
	            System.out.println(a1.descricao());
	            System.out.println(a1.insert());
	            System.out.println(a2.descricao());
	            System.out.println(a2.insert());
	            System.out.println(a3.descricao());
	            System.out.println(a3.insert());
	            System.out.println(m1.descricao());
	            System.out.println(m1.insert());
	            System.out.println(m2.descricao());
	            System.out.println(m2.insert());
	            System.out.println(m3.descricao());
	            System.out.println(m3.insert());
	            System.out.println(c1.descricao());
	            System.out.println(c1.insert());
	            System.out.println(c2.descricao());
	            System.out.println(c2.insert());
	            System.out.println(c3.descricao());
	            System.out.println(c3.insert());
	            System.out.println(b1.descricao());
	            System.out.println(b1.insert());
	            System.out.println(b2.descricao());
	            System.out.println(b2.insert());
	            System.out.println(b3.descricao());
	            System.out.println(b3.insert());
	            System.out.println(s1.descricao());
	            System.out.println(s1.insert());
	            System.out.println(s2.descricao());
	            System.out.println(s2.insert());
	            System.out.println(s3.descricao());
	            System.out.println(s3.insert());
	     } 
		 catch (IllegalArgumentException erro) {
	            System.err.println("Erro: " + erro.getMessage());
	          }
	   }
}
