from flask import Flask

app = Flask(__name__)

@app.route('/')
def hello():
    return "Hello, World!"

if __name__ == '__main__':
    app.run(host='0.0.0.0')


import random

print("Feito por João Pedro de Lima R. Ferro!")
print("RA: 199389")
def jogo_adivinha():
    #
    print("***********************************")
    print("*Bem vindo ao Jogo de Adivinhação *")
    print("***********************************")
    #
    numero_secreto = round(random.randrange(1, 101)) 
    print('Qual é o nível de dificuldade desejado? \n')
    print('Fácil (1) - Médio (2) - Difícil (3)')
    nivel = int(input('NÍVEL : '))
    #
    if nivel == 1:
        total_tentativas = 14 
    elif nivel == 2:
        total_tentativas = 7
    else:
        total_tentativas = 5 
    rodada = 1 
    #
    while rodada <= total_tentativas:
        print("Tentativa {} de {}".format(rodada, total_tentativas))
        chute_str = input("Digite um número de 1 a 100: ")
        print("Seu chute é", chute_str)
        chute = int(chute_str)

        if (chute < 1) or (chute > 100):
            print("Chute inválido")
            continue

        acertou = chute == numero_secreto 
        maior = chute > numero_secreto 
        menor = chute < numero_secreto

        if acertou: 
            print("Você acertou!")
            break
        else:
            if maior:
                print("Errou. Seu chute foi maior do que o número secreto!")
            elif menor:
                print("Errou. Seu chute foi menor do que o número secreto!")
        rodada = rodada + 1
    #
    print('O número secreto era', numero_secreto)
    print('Fim do jogo...')

# Chamando a função para iniciar o jogo
jogo_adivinha()
