package com.example.spesuez.Evaluation;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.spesuez.Evaluation.helpers.Member;
import com.example.spesuez.Evaluation.helpers.MemberLoader;
import com.example.spesuez.Evaluation.helpers.MySharedPrefrencesAdapter;
import com.example.spesuez.R;

import java.util.ArrayList;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class FragB extends Fragment {
    // programming vars
    private CountDownTimer c2=new CounterOfFragC(100,100);
    private CountDownTimer c=new CounterOfAnimi(3000,1000);
    private   Context a;
    private Member user_member =new Member();
    public static ArrayList<Member> my_members;
    View view;
    String def="NA";
    MySharedPrefrencesAdapter mySharedPrefrencesAdapter;
    //Gui vars
    private ImageView bookIconImageView;
    private ProgressBar loadingProgressBar;
    private RelativeLayout rootView, afterAnimationView;
    private EditText id;
    private EditText password;
    private Button btn;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragb,container,false);
        initViews();
        mySharedPrefrencesAdapter=new MySharedPrefrencesAdapter(getActivity());
        if(mySharedPrefrencesAdapter.getState()==true){
        new MemberLoader(c,getContext()).execute();
        }else {
            user_member=mySharedPrefrencesAdapter.loadMember();
            c2.start();
        }

        return view;
    }

    private void initViews() {
        bookIconImageView = (ImageView) view.findViewById(R.id.bookIconImageView);
        loadingProgressBar = view.findViewById(R.id.loadingProgressBar);
        id=view.findViewById(R.id.emailEditText);
        password=view.findViewById(R.id.passwordEditText);
        rootView = view.findViewById(R.id.rootView);
        btn=view.findViewById(R.id.loginButton);
        afterAnimationView = view.findViewById(R.id.afterAnimationView);
    }

    private void startAnimation() {
        bookIconImageView.setImageResource(R.drawable.spe);
        ViewPropertyAnimator viewPropertyAnimator = bookIconImageView.animate();
        viewPropertyAnimator.scaleX( 0.33f);
        viewPropertyAnimator.scaleY( 0.33f);
        viewPropertyAnimator.x(-120f);
        viewPropertyAnimator.y(-80f);
        viewPropertyAnimator.setDuration(1500);
        viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                afterAnimationView.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
    private class CounterOfAnimi extends CountDownTimer{
        public CounterOfAnimi(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {

            loadingProgressBar.setVisibility(GONE);
            rootView.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.colorBackground));
            startAnimation();
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(Member m:my_members){
                        if(m.getId().equals(id.getText().toString())&&m.getPassword().equals(password.getText().toString())){
                            user_member=m;
                            mySharedPrefrencesAdapter.saveMember(user_member);
                            c2.start();
                            break;

                        }
                        }if(user_member.getId()==null){
                        Toast.makeText(getContext(), "Sorry, you are n`t registered", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }


    private class CounterOfFragC extends CountDownTimer{
    private CounterOfFragC(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    @Override
    public void onTick(long millisUntilFinished) {

    }

    @Override
    public void onFinish() {
         Bundle b=new Bundle();
         b.putSerializable("user_member",user_member);
        ((MainActivity)getActivity()).startFragC(b);
    }
}
}

