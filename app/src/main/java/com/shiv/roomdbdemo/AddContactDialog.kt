package com.shiv.roomdbdemo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AddContactDialog(
    state : ContactState,
    onEvent: (ContactEvent) -> Unit,
    modifier: Modifier = Modifier
){
    AlertDialog(
        modifier = modifier,
        onDismissRequest = { onEvent(ContactEvent.HideDialog) },
        title = {
            Text(text = "Add Contact")
        },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                //TODO : Change the text field to better looking one
                BasicTextField(value = state.firstName, onValueChange = {
                    onEvent(ContactEvent.SetFirstName(it))
                })
                BasicTextField(value = state.lastName, onValueChange = {
                    onEvent(ContactEvent.SetLastName(it))
                })
                BasicTextField(value = state.phoneNumber, onValueChange = {
                    onEvent(ContactEvent.SetPhoneNumber(it))
                })
            }
        },
        confirmButton = {
            Box(modifier = Modifier
                .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ){
                Button(onClick = { onEvent(ContactEvent.SaveContact)}) {
                    Text("Save")

                }
            }
        }
    )
}