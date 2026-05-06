import express from 'express'
import { PrismaCliente } from '@prisma/client'

const prisma = new PrismaCliente()
const app = express()
app.use(express.json())

 
app.post("/usuarios", async (req, res) => {
    
    await prisma.user.create({
        data: {
            email: req.body.email,
            name: req.body.name,
        }
    })
 
    res.status(201).json(req.body)
})

app.get('/usuarios', async (req, res) => {
  try {
    let users = [];

    if (req.query.name) {
      users = await prisma.user.findMany({
        where: {
          name: req.query.name
        }
      });
    } else {
      users = await prisma.user.findMany()
    }

    res.status(200).json(users)
})


app.put('/usuarios/:id', async (req, res) =>{

    await prisma.user.update({
        where: {
            id: req.params.id
        },
        data: {
            email: req.body.email,
            name: req.body.name,
        }
    })

    res.status(201).json(req.body)
}) 

app.delete('/usuarios/:id', async (req, res) =>{

    await prisma.user.delete({
        where: {
            id: req.params.id
        },
        
    })

        res.status(200).json({message: "Usuario deletado com sucesso!"})
}) 

app.listen(3000)
}