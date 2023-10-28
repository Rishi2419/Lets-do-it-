package com.example.assigntodo

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.assigntodo.auth.SigninActivity
import com.example.assigntodo.databinding.ForgotPasswordBinding
import com.example.assigntodo.databinding.FragmentEmployeeBinding
import com.example.assigntodo.databinding.FragmentWorkBinding
import com.example.assigntodo.databinding.ShowLogoutBinding
import com.google.firebase.auth.FirebaseAuth

class EmployeeFragment : Fragment() {

    private lateinit var binding: FragmentEmployeeBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmployeeBinding.inflate(layoutInflater)

        binding.tbemployees.setOnMenuItemClickListener{
            when(it.itemId){
                R.id.Logout->{
                    showlogout()
                    true
                }
                else-> false
            }
        }
        return binding.root
    }

    private fun showLogoutDialog() {
        val builder= AlertDialog.Builder(requireContext())
        val alertDialog= builder.create()
        builder.setTitle("Log Out")
            .setMessage("Are you sure you want to Logout?")
            .setPositiveButton("Yes"){_,_->
                FirebaseAuth.getInstance().signOut()
                startActivity(Intent(requireContext(),SigninActivity::class.java))
                requireActivity().finish()
            }
            .setNegativeButton("No"){_,_->
                alertDialog.dismiss()
            }
            .show()
            .setCancelable(false)
    }

    private fun showlogout() {
        val dialog = ShowLogoutBinding.inflate(layoutInflater)

        val alertDialog = AlertDialog.Builder(requireContext())
            .setView(dialog.root)
            .show()

        dialog.LogoutYes.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(requireContext(),SigninActivity::class.java))
            requireActivity().finish()
        }
        dialog.Logoutno.setOnClickListener{
            alertDialog.dismiss()
        }

    }


}