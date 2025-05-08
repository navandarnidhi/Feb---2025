import express from 'express';
import mysql from 'mysql2';

const conn = mysql.createConnection({
    host: "localhost",
    user: "Nidhi",
    password: "1307cdac",
    database: "cdac"
});

conn.connect((error) => {
    if (error) {
        console.log(error);
    } else {
        console.log("DB connected!");
    }
});

const PORT = 7800;
const app = express();
app.use(express.json());

app.get("/", (req, res) => {
    res.status(200).send({ message: 'Welcome to inventory CRUD' });
});

// CREATE inventory item
app.post("/inventory", (req, res) => {
    try {
        const data = req.body;
        const qry = `INSERT INTO inventory (item_name, quantity, price, supplier, date_received) 
                     VALUES (?, ?, ?, ?, ?)`;
        conn.query(qry, [data.item_name, data.quantity, data.price, data.supplier, data.date_received], (error, result) => {
            if (error) {
                console.log(error);
                if (error.errno === 1062) {
                    res.status(400).send({ message: 'Item name must be unique!' });
                } else {
                    res.status(500).send({ message: 'Error inserting data' });
                }
            } else {
                res.status(201).send({ message: 'Inventory item added' });
            }
        });
    } catch (error) {
        res.status(500).send({ message: 'Something went wrong' });
    }
});

// READ all items
app.get("/inventory", (req, res) => {
    try {
        conn.query("SELECT * FROM inventory", (error, result) => {
            if (error) {
                console.log(error);
                res.status(500).send({ message: 'Error fetching data' });
            } else {
                res.status(200).send(result);
            }
        });
    } catch (error) {
        res.status(500).send({ message: 'Something went wrong' });
    }
});

// READ item by ID
app.get("/inventory/:id", (req, res) => {
    try {
        const id = parseInt(req.params.id);
        conn.query("SELECT * FROM inventory WHERE item_id = ?", [id], (error, result) => {
            if (error) {
                console.log(error);
                res.status(500).send({ message: 'Error fetching item' });
            } else if (result.length === 0) {
                res.status(404).send({ message: `Item ID ${id} not found` });
            } else {
                res.status(200).send(result[0]);
            }
        });
    } catch (error) {
        res.status(500).send({ message: 'Something went wrong' });
    }
});

// DELETE item
app.delete("/inventory/:id", (req, res) => {
    try {
        const id = parseInt(req.params.id);
        conn.query("DELETE FROM inventory WHERE item_id = ?", [id], (error, result) => {
            if (error) {
                console.log(error);
                res.status(500).send({ message: 'Error deleting item' });
            } else {
                res.status(200).send({ message: 'Item deleted' });
            }
        });
    } catch (error) {
        res.status(500).send({ message: 'Something went wrong' });
    }
});

// UPDATE item
app.put("/inventory/:id", (req, res) => {
    try {
        const id = parseInt(req.params.id);
        const data = req.body;
        const qry = `UPDATE inventory 
                     SET item_name = ?, quantity = ?, price = ?, supplier = ?, date_received = ? 
                     WHERE item_id = ?`;
        conn.query(qry, [data.item_name, data.quantity, data.price, data.supplier, data.date_received, id], (error, result) => {
            if (error) {
                console.log(error);
                res.status(500).send({ message: 'Error updating item' });
            } else {
                res.status(200).send({ message: 'Item updated' });
            }
        });
    } catch (error) {
        res.status(500).send({ message: 'Something went wrong' });
    }
});

app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`);
});
